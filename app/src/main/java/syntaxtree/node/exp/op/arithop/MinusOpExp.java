package node;

public class MinusOpExp extends ArithOpExp {

  public MinusOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "-";
  }
}
