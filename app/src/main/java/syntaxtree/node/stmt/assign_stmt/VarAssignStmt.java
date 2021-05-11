package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.LOADGLOBAL;
import bytecode.instructions.LOADLOCAL;
import bytecode.instructions.PUTFIELD;
import symboltable.Symboltable;

public class VarAssignStmt extends AssignStmt {

  Var v;

  public VarAssignStmt(Exp e, Var v) {
    super(e);
    this.v = v;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) +
      v.printSyntaxtree(indent+1) +
      " " +
      e.printSyntaxtree(indent+1) +
      ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {

    symboltable.Type varType = v.semanticAnalyze(table);    
    symboltable.Type expType = e.semanticAnalyze(table);

    if (!varType.equals(expType)) {
      throw new error.MismatchedTypes("Variable " +
				      v.toString() +
				      " of type " +
				      varType.toString() +
				      " cannot be assigned to value of type " +
				      expType.toString());
    }
    this.table = table;

    // System.out.println(v);
    // System.out.println(this.table.isLocal(v.toString()));
    return expType;
  }

  @Override
  public void codegen(CodeFile codefile, CodeProcedure procedure) {

    //there is no handling of field of type struct(reference)
    if (!v.isStructField()) {
      if (e.isHeapAllocation()) {
	//this may be put in the NewNameExp?
	e.codegen(codefile, procedure);
      }
      else {
	e.pushOnStack(codefile, procedure);	
      }

      if (!this.table.isLocal(v.toString())) {
	v.storeGlobal(v.toString(), codefile, procedure);
      }
      else {
	// e.pushOnStack(codefile, procedure);
	v.storeLocal(v.toString(), codefile, procedure);
      }
    }    
    else {
      //is a field in a struct
      String varName = v.toString();      
      String structName = table.lookupVar(varName).getType().toString();
      String fieldName = v.getFieldName();
      e.pushOnStack(codefile, procedure);
      procedure.addInstruction(table.existsInScope(varName) ?
			       new LOADLOCAL(procedure.variableNumber(varName)) :
			       new LOADGLOBAL(codefile.globalVariableNumber(varName)));
            
      procedure.addInstruction(new PUTFIELD(procedure.fieldNumber(structName, fieldName),
					    procedure.structNumber(structName)));
      codefile.updateProcedure(procedure);
    }
  }
}
