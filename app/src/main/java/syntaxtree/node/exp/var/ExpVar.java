package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.GETFIELD;
import bytecode.instructions.LOADLOCAL;
import bytecode.instructions.LOADGLOBAL;
import bytecode.type.RefType;
import symboltable.Symboltable;

public class ExpVar extends Var {

  private Exp e;
  private Name n;

  public ExpVar(Exp e, Name n) {
    this.e = e;
    this.n = n;
  }

  public String printSyntaxtree(int indent) {
    return
      "(. " +
      e.printSyntaxtree(indent) +
      " " +
      n.printSyntaxtree(indent) +
      ")";
  }

  public String toString() {
    return e.toString();// + "." + n.toString();
  }

  public String getFieldName() {
    return n.toString();
  }

  @Override
  public boolean isStructField() {
    return true;
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Type expType = e.semanticAnalyze(table);
    if (!expType.isStruct()) {
      throw new error.NoStruct(e +
			       " is not of type struct " +
			       " and can therefore not hold member " +
			       n.toString());
    }

    symboltable.StructType structType = (symboltable.StructType) expType;
    symboltable.Var var = structType.getInstance(n.toString());
    if (var == null) {
      throw new error.NoStructMember("Struct does not have any member " +
				     n.toString());
    }

    this.table = table;
    return var.getType();
  }

  
  
  @Override
  public void pushOnStack(CodeFile codefile, CodeProcedure procedure) {
    //this is maybe more than push on stack? divide it?
    symboltable.Var struct = (symboltable.Var) table.lookupVar(e.toString());
    String typerep = struct.getType().toString();

    procedure.addInstruction(table.existsInScope(e.toString()) ?
			     new LOADLOCAL(procedure.variableNumber(e.toString())) :
			     new LOADGLOBAL(codefile.globalVariableNumber(e.toString())));

    procedure.addInstruction(new GETFIELD(procedure.fieldNumber(typerep, n.toString()),
					  codefile.structNumber(typerep)));      
  }
}
