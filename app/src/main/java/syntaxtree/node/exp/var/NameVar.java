package node;

public class NameVar extends Var {

  private Name n;

  public NameVar(Name n) {
    this.n = n;
  }

  public String printSyntaxtree(int indent) {
    return n.printSyntaxtree(indent);
  }
}
