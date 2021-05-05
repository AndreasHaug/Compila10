package node;

import bytecode.CodeProcedure;
import bytecode.instructions.NEQ;

public class NotEqualsOpExp extends RelOpExp {

  public NotEqualsOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "<>";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new NEQ());    
  }
}
