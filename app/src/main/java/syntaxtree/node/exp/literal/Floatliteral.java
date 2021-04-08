package node;

public class Floatliteral extends Literal {

  private double l;
  
  public Floatliteral(double l) {
    this.l = l;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return String.format("Floatliteral:%f", l);
  }

  @Override
  public Object getLiteralValue() {
    return (double) l;
  }

}
