package node;

import symboltable.Symboltable;

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

  // @Override
  // public symboltable.Type getType() {
    // return symboltable.Type.boolType;
  // }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.boolType;
  }
}
