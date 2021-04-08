package node;

public abstract class OpExp extends Exp {

  protected String rep;
  Exp l, r;

  public OpExp(Exp l, Exp r) {
    this.l = l;
    this.r = r;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return "(" +
      rep +
      " " +
      l.printSyntaxtree(indent) +
      " " +
      r.printSyntaxtree(indent) +
      ")";
  }
}
