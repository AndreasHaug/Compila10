package node;

import bytecode.CodeProcedure;
import bytecode.instructions.GT;

public class GreaterOpExp extends RelOpExp {

  public GreaterOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = ">";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new GT());
  }

}
