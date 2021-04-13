package node;

import symboltable.Symboltable;

public class Intliteral extends Literal {

  private int l;
  
  public Intliteral(int l) {
    this.l = l;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return String.format("Intliteral:%d", l);
  }

  @Override
  public Object getLiteralValue() {
    return (int) l;
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.intType;
  }

}
