package node;

public abstract class Stmt implements syntaxtree.SyntaxtreeProperty {

  protected Exp e;

  public Stmt(Exp e) {
    this.e = e;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return "stmt abstract super class not implemented";
  }
}
