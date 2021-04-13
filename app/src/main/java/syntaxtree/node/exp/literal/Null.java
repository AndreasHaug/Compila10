package node;

import symboltable.Symboltable;

public class Null extends Literal {
  
  @Override
  public String printSyntaxtree(int indent) {
    return "null";
  }

  @Override
  public Object getLiteralValue() {
    return null;
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.nullType;
  }
}
