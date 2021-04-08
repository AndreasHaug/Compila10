package node;

public class Boolliteral extends Literal {

  private boolean b;
  
  public Boolliteral(boolean b) {
    this.b = b;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return Boolean.toString(b);
  }

  @Override
  public Object getLiteralValue() {
    return (boolean) b;
  }

}
