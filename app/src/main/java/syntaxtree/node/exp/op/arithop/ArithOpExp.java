package node;

public class ArithOpExp extends OpExp {

  public ArithOpExp(Exp l, Exp r) {
    super(l, r);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent);
    // return "(" +
      // rep +
      // " " +
      // l.printSyntaxtree(indent) +
      // " " +
      // r.printSyntaxtree(indent) +
       // ")";
  }
}
