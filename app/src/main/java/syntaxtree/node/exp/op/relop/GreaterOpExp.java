package node;

public class GreaterOpExp extends RelOpExp {

  public GreaterOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = ">";
  }
}
