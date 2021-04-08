package node;

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
}

