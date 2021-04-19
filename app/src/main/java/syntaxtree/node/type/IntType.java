package node;

import symboltable.Symboltable;

public class IntType extends Type {

  public String printSyntaxtree(int indent) {
    return "TYPE:int";
  }

  public String getTypeRep() {
    return "int";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.intType;
  }
}
