package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.ADD;
import bytecode.instructions.PUSHINT;
import bytecode.instructions.STORELOCAL;
import bytecode.instructions.STOREGLOBAL;

public class AddOpExp extends ArithOpExp {

  public AddOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "+";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new ADD());
  }
}
