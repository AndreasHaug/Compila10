package node;

public class Stringliteral extends Literal {

  private String s;
  
  public Stringliteral(String s) {
    this.s = s;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return "Stringliteral:" + "\"" + s + "\"";
  }

  @Override
  public Object getLiteralValue() {
    return (String) s;
  }

}
