package node;

public class AddOpExp extends ArithOpExp {

    public AddOpExp(Exp l, Exp r) {
      super(l, r);
      this.rep = "+";
    }  
  }
