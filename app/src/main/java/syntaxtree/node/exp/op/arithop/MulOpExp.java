package node;

public class MulOpExp extends ArithOpExp {

    public MulOpExp(Exp l, Exp r) {
      super(l, r);
      this.rep = "*";
    }  
  }
