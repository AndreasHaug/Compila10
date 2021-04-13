package node;

public class PowerOpExp extends ArithOpExp {

  public PowerOpExp(Exp l, Exp r) {
    super(l, r);
    this.rep = "pow";
  }  
}
