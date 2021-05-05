package node;

import bytecode.CodeProcedure;
import bytecode.instructions.DIV;

public class DivOpExp extends ArithOpExp {

  public DivOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "/";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new DIV());
  }
}
