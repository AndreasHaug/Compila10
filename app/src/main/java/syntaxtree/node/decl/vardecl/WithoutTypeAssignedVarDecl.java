package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import symboltable.Symboltable;

public class WithoutTypeAssignedVarDecl extends VarDecl {

  public WithoutTypeAssignedVarDecl(Name name, Exp exp) {
    super(name);
    this.exp = exp;
    this.type = null;
  }

  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) +      
      exp.printSyntaxtree(indent) +
      ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    if (table.existsInScope(name.toString())) {
      throw new error.NameAlreadyDeclared(name.toString());
    }

    symboltable.Type expType = exp.semanticAnalyze(table);
    table.addVar(name.toString(),
		 new symboltable.Var(name.toString(), exp, expType));

    this.table = table;
    return expType;
  }

  // @Override
  // public void codegen(Symboltable table, CodeFile codefile) {
  //   symboltable.Type sType = table.lookupVar(name.toString()).getType();
  //   if (sType.isPrimitive()) {
  //     codefile.addVariable(name.toString());
  //     codefile.updateVariable(name.toString(), sType.getRuntime());
  //   }
  //   else {
  //     codefile.addVariable(name.toString());
  //     codefile.updateVariable(name.toString(),
  // 			      new bytecode.type.RefType(codefile.structNumber(type.getTypeRep())));      
  //   }
  // }

  @Override
  public void codegen(CodeFile codefile, CodeProcedure procedure) {    
    super.codegen(codefile, procedure);
    if (!exp.isHeapAllocation()) {
      exp.storeLocal(name.toString(), codefile, procedure);      
    }
    else {
      exp.codegen(codefile, procedure);

      if (!table.existsInScope(name.toString())) {
	exp.storeGlobal(name.toString(), codefile, procedure);
      }
      else {
	exp.storeLocal(name.toString(), codefile, procedure);
      }
    }
  }
}
