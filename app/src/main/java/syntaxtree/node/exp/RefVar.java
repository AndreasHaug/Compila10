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
}

