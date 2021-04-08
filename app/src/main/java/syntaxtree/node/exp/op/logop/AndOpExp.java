package node;

public class AndOpExp extends LogOpExp {

  public AndOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "and";
  }
}
