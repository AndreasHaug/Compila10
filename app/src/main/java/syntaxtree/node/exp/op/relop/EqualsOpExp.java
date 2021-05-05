package node;

import bytecode.CodeProcedure;
import bytecode.instructions.EQ;

public class EqualsOpExp extends RelOpExp {

  public EqualsOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "=";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new EQ());
  }
}
