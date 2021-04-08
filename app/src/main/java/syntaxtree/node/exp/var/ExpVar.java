package node;

public class ExpVar extends Var {

  private Exp e;
  private Name n;

  public ExpVar(Exp e, Name n) {
    this.e = e;
    this.n = n;
  }

  public String printSyntaxtree(int indent) {
    return
      // super.printSyntaxtree(indent) +
      "(. " +
      e.printSyntaxtree(indent) +
      " " +
      n.printSyntaxtree(indent) +
      ")";
  }
}
