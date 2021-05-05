package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.SUB;
import bytecode.instructions.STORELOCAL;
import bytecode.instructions.STOREGLOBAL;

public class MinusOpExp extends ArithOpExp {

  public MinusOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "-";
  }

  @Override
  public void addOperatorInstruction(CodeProcedure procedure) {
    procedure.addInstruction(new SUB());
  }
}
