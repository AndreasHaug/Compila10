package node;

public class OrOpExp extends LogOpExp {

  public OrOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "or";
  }

  // @Override
  // public String printSyntaxtree(int indent) {
  //   return indent(indent) + super.printSyntaxtree(indent);
  // }

}
