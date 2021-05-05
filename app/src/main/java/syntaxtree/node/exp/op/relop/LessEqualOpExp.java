package node;

import bytecode.CodeProcedure;
import bytecode.instructions.LTEQ;

public class LessEqualOpExp extends RelOpExp {

  public LessEqualOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "<=";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new LTEQ());
  }
}
