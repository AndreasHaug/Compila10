package node;

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

  public void semanticAnalyze(Symboltable table) {
    
  }
  
}
