package node;

public class DivOpExp extends ArithOpExp {

  public DivOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "/";
  }
}
