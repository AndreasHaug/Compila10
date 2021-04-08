package node;

public class Null extends Literal {
  
  @Override
  public String printSyntaxtree(int indent) {
    return "null";
  }

  @Override
  public Object getLiteralValue() {
    return null;
    // throw new IllegalAccessException();
  }
}
