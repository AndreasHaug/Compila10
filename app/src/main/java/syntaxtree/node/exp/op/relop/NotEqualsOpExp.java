package node;

public class NotEqualsOpExp extends RelOpExp {

  public NotEqualsOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "<>";
  }
}
