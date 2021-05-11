package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import symboltable.Symboltable;

public class WithTypeAssignedVarDecl extends VarDecl {

  public WithTypeAssignedVarDecl(Name name, Type type, Exp exp) {
    super(name, type, exp);
  }


  public String printSyntaxtree(int indent) {
    return
      super.printSyntaxtree(indent) +
      type.printSyntaxtree(indent) +
      " (" +
      exp.printSyntaxtree(indent) +
      "))";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    if (table.existsInScope(name.toString())) {
      throw new error.NameAlreadyDeclared(name.toString());
    }

    /**
     * type declared
     */
    String typeRef = type.getTypeRep();
    symboltable.Type declType = table.lookupType(typeRef);  

    if (declType == null) {
      throw new error.NoTypeExists(typeRef);
    }

    /**
     * type of expression
     */
    symboltable.Type expType = exp.semanticAnalyze(table);

    if (!declType.equals(expType)) {
      throw new error.MismatchedTypes("Cannot assign " +
				      expType.toString() +
				      " to variable declared as " +
					declType.toString());
    }

    table.addVar(name.toString(),
		 new symboltable.Var(name.toString(), exp, expType));

    this.table = table;
    return declType;
  }

  // public void storeGlobal(CodeFile codefile, CodeProcedure proc) {
    // exp.storeGlobal(codefile, proc);
  // }


  // @Override
  // public void codegen(CodeFile codefile) {
  //   super.codegen(codefile);
  // }

  // public void codegen(CodeFile codefile, CodeProcedure procedure) {
  //   symboltable.Type sType = table.lookupVar(name.toString()).getType();
  //   if (sType.isPrimitive()) {
  //     procedure.addLocalVariable(name.toString(), sType.getRuntime());
  //   }
  //   else {
  //     procedure.addLocalVariable(null, null);
  //   }
  // }
  public void codegen(CodeFile codefile, CodeProcedure procedure) {
    super.codegen(codefile, procedure);
    if (!exp.isHeapAllocation()) {
      exp.pushOnStack(codefile, procedure);
      exp.storeLocal(name.toString(), codefile, procedure);      
    }
    else {      
      exp.codegen(codefile, procedure);
    }
    
  }
  
}
