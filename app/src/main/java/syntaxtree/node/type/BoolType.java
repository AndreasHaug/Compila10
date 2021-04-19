package node;

import symboltable.Symboltable;

public class BoolType extends Type {

  public String printSyntaxtree(int indent) {
    return "TYPE:bool";
  }

  public String getTypeRep() {
    return "bool";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.boolType;
  }
}
