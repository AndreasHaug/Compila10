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

  public void semanticAnalyze(Symboltable table) {
    
  } 
}
