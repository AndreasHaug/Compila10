package node;

import bytecode.CodeProcedure;
import bytecode.instructions.GTEQ;

public class GreaterEqualOpExp extends RelOpExp {

  public GreaterEqualOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = ">=";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new GTEQ());
  }
}
