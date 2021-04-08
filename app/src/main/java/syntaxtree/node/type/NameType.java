package node;

public class NameType extends Type {

  private Name n;

  public NameType(Name n) {
    this.n = n;
  }

  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) +
      n.printSyntaxtree(indent);
  }

}
