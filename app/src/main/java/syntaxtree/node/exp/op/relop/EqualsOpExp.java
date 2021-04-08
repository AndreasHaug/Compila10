package node;

public class EqualsOpExp extends RelOpExp {

  public EqualsOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "=";
  }
}
