package node;

public class RefVar extends Exp implements
				syntaxtree.SyntaxtreeProperty {

  private Var var;

  public RefVar(Var var) {
    this.var = var;
  }
  
  
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(REFVAR " +
      var.printSyntaxtree(indent+1) + ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(symboltable.Symboltable table) {
    // return null;

    return table.lookupType("ref" + "(" + var.semanticAnalyze(table).toString() + ")");
  }
}

