package node;

public class DerefDerefVar extends DerefVar {

  private DerefVar dv;
  
  public DerefDerefVar(DerefVar dv) {
    super(null);
    this.dv = dv;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(DEREF_VAR " +
      dv.printSyntaxtree(indent+1) + ")";
  }
}

