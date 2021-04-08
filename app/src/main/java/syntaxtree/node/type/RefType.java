package node;

public class RefType extends Type {

  private Type t;

  public RefType(Type t) {
    this.t = t;;
  }

  public String printSyntaxtree(int indent) {
    return
      indent(indent+1) +
      "(" +
      super.printSyntaxtree(indent+1) +
      "ref " +
      t.printSyntaxtree(indent+1)
      + ")";
  }
}
