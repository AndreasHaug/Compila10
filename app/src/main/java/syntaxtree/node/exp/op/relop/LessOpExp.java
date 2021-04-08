package node;

public class LessOpExp extends RelOpExp {

  public LessOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "<";
  }
}
