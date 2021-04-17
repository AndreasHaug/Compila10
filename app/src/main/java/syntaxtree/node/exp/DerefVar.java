package node;

import symboltable.Symboltable;

public class DerefVar extends Exp {

  private Var var;

  public DerefVar(Var var) {

    this.var = var;
  }
  
  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(DEREF_VAR " +
      var.printSyntaxtree(indent+1) +
      ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return var.semanticAnalyze(table);
  }
}

