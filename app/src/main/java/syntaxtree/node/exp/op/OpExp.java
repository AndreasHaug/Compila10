package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.STORELOCAL;
import bytecode.instructions.STOREGLOBAL;

public abstract class OpExp extends Exp {

  protected String rep;
  Exp l, r;

  public OpExp(Exp l, Exp r) {
    this.l = l;
    this.r = r;
  }

  public void addOperatorInstruction(CodeProcedure procedure) {
    System.out.println("addOperatorInstruction in " + this.getClass().getName() + " not implemented");
  }
  
  @Override
  public String printSyntaxtree(int indent) {
    return "(" +
      rep +
      " " +
      l.printSyntaxtree(indent) +
      " " +
      r.printSyntaxtree(indent) +
      ")";
  }

  private void pushOnStackAndAddInstruction(CodeFile codefile, CodeProcedure procedure) {  
    l.pushOnStack(codefile, procedure);
    r.pushOnStack(codefile, procedure);
    this.addOperatorInstruction(procedure);
  }

  public void pushOnStack(CodeFile codefile, CodeProcedure procedure) {
    pushOnStackAndAddInstruction(codefile, procedure);
  }

  // public void pushOnStack(CodeFile codefile, CodeProcedure procedure) {
  //   pushOnStackAndAddInstruction(codefile, procedure);
  // }
  
  public void storeLocal(String varName, CodeFile codefile, CodeProcedure procedure) {
    // pushOnStackAndAddInstruction(codefile, procedure);
    procedure.addInstruction(new STORELOCAL(procedure.variableNumber(varName)));
    codefile.updateProcedure(procedure);    
  }

  public void storeGlobal(String varName, CodeFile codefile, CodeProcedure procedure) {
    // pushOnStackAndAddInstruction(codefile, procedure);
    procedure.addInstruction(new STOREGLOBAL(procedure.globalVariableNumber(varName)));
    codefile.updateProcedure(procedure);
  }
}
