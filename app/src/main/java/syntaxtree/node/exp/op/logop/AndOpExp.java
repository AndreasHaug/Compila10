package node;

import bytecode.CodeProcedure;
import bytecode.instructions.AND;

public class AndOpExp extends LogOpExp {

  public AndOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "and";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new AND());
  }
}
