package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.NEW;
import bytecode.instructions.STOREGLOBAL;
import bytecode.instructions.STORELOCAL;
import symboltable.Symboltable;

public class NewNameExp extends Exp {

  private Name n;

  public NewNameExp(Name n) {
    this.n = n;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return
      indent(indent) +
      "(NEW " +
      n.printSyntaxtree(indent) +
      ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    if (table.lookupType(n.toString()) == null) {
      throw new error
	.NameNotFound("Name " + n.toString() + " cannot be found");      
    }
    else {
      return table.lookupType(n.toString());      
    }
  }

  @Override
  public boolean isHeapAllocation() {
    return true;
  }

  @Override
  public String toString() {
    return n.toString();
  }

  @Override
  public void storeGlobal(String varName, CodeFile codefile, CodeProcedure proc)  {
    //here one must assume the reference is pushed on top as a result of a new instruction
    proc.addInstruction(new STOREGLOBAL(codefile.globalVariableNumber(varName)));
    //lookup in table to find the expression?
  }

  @Override
  public void storeLocal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new STORELOCAL(proc.variableNumber(varName)));
  }

  //codegeneration goal in this unit is to make instructions
  //saving a value of a struct on the heap
  // public void codegen(CodeFile codefile) {

  // }
  
  public void codegen(CodeFile codefile, CodeProcedure procedure) {
    int structnum = codefile.structNumber(n.toString());
    procedure.addInstruction(new NEW(structnum));
    codefile.updateProcedure(procedure);
  }
  //same for both, but the latter is codegeneration inside a procedure
  
}
