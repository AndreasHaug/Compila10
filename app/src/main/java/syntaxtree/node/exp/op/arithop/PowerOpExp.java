package node;

import bytecode.CodeProcedure;
import bytecode.instructions.EXP;

public class PowerOpExp extends ArithOpExp {

  public PowerOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "pow";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new EXP());
  }
}
