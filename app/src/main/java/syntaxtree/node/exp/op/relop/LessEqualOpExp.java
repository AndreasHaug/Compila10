package node;

public class LessEqualOpExp extends RelOpExp {

  public LessEqualOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "<=";
  }
}
