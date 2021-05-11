package node;

import bytecode.CodeProcedure;
import bytecode.instructions.OR;

public class OrOpExp extends LogOpExp {

  public OrOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "or";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new OR());
  }
}
