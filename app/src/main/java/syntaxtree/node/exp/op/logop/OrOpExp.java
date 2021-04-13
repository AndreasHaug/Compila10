package node;

public class OrOpExp extends LogOpExp {

  public OrOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "or";
  }
}
