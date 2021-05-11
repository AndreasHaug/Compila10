package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.LOADGLOBAL;
import bytecode.instructions.LOADLOCAL;
import bytecode.instructions.STOREGLOBAL;
import bytecode.instructions.STORELOCAL;
import symboltable.Symboltable;

public class NameVar extends Var {

  private Name n;

  public NameVar(Name n) {
    this.n = n;
  }

  public String printSyntaxtree(int indent) {
    return n.printSyntaxtree(indent);
  }

  public String toString() {
    return n.toString();
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Var variable = table.lookupVar(n.toString());
    if (variable == null) {
      throw new error.NameNotFound("Name " + n.toString() + " cannot be found");
    }
    
    this.table = table;
    return variable.getType();
  }

  @Override
  public void pushOnStack(CodeFile codefile, CodeProcedure procedure) {
    procedure.addInstruction(table.isLocal(n.toString()) ?
			     new LOADLOCAL(procedure.variableNumber(n.toString())) :
			     new LOADGLOBAL(procedure.globalVariableNumber(n.toString())));    
  }

  // @Override
  // public void storeGlobal(String varName, CodeFile codefile, CodeProcedure procedure) {
    // System.out.println(n);
    // procedure.addInstruction(new LOADGLOBAL(procedure.globalVariableNumber(n.toString())));
    // System.out.println(n);
    // System.out.println(varName);
    // procedure.addInstruction(new STOREGLOBAL(procedure.variableNumber(varName)));
    			     
  // }

  @Override
  public void storeLocal(String varName, CodeFile codefile, CodeProcedure procedure) {
    procedure.addInstruction(new STORELOCAL(procedure.variableNumber(n.toString())));
  }

  @Override
  public void storeGlobal(String varName, CodeFile codefile, CodeProcedure procedure) {
    procedure.addInstruction(new STOREGLOBAL(codefile.globalVariableNumber(varName)));
    codefile.updateProcedure(procedure);
  }
}
