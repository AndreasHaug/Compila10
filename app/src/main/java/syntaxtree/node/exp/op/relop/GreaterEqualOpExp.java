package node;

public class GreaterEqualOpExp extends RelOpExp {

  public GreaterEqualOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = ">=";
  }
}
