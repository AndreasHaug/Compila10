package node;

import symboltable.Symboltable;

public class FloatType extends Type {

  public String printSyntaxtree(int indent) {
    return "TYPE:float";
  }

  public String getTypeRep() {
    return "float";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.floatType;
  }
}
