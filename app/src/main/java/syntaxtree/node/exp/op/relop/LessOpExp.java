package node;

import bytecode.CodeProcedure;
import bytecode.instructions.LT;

public class LessOpExp extends RelOpExp {

  public LessOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "<";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new LT());
  }  

}
