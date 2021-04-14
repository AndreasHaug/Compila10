package node;

public class ParamfieldDecl extends Decl {

  private Name n;
  private Type t;

  public ParamfieldDecl(Name n, Type t) {
    this.n = n;
    this.t = t;
  }

  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(PARAMFIELD_DECL " +
      n.printSyntaxtree(indent) +
      " " +
      t.printSyntaxtree(indent) +
      ")";
  }

  public Name getName() {
    return n;
  }

  public Type getType() {
    return t;
  }
}
