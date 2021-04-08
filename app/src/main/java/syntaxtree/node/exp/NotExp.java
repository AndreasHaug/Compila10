package node;

public class NotExp extends Exp {

  private Exp e;

  public NotExp(Exp e) {
    this.e = e;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return String.format("%s(not %s)",
			 indent(indent),
			 e.printSyntaxtree(indent));
  }

}
