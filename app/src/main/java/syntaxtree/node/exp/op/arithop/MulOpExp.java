package node;

import bytecode.CodeProcedure;
import bytecode.instructions.MUL;

public class MulOpExp extends ArithOpExp {

  public MulOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "*";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new MUL());
  }
}
