package node;

public class NewNameExp extends Exp {

  private Name n;

  public NewNameExp(Name n) {
    this.n = n;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return
      indent(indent) +
      "(NEW " +
      n.printSyntaxtree(indent) +
      ")";
  }

  
}
