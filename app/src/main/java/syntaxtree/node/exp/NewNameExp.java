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
    proc.addInstruction(new STOREGLOBAL(codefile.globalVariableNumber(varName)));
  }

  @Override
  public void storeLocal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new STORELOCAL(proc.variableNumber(varName)));
  }
  
  @Override
  public void codegen(CodeFile codefile, CodeProcedure procedure) {
    int structnum = codefile.structNumber(n.toString());
    procedure.addInstruction(new NEW(structnum));
    codefile.updateProcedure(procedure);
  }  
}
