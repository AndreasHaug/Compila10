package node;

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
    symboltable.Type expType = exp.semanticAnalyze(table);
    table.addVar(name.toString(),
		 new symboltable.Var(name.toString(), exp, expType));
    return expType;
  } 
}
