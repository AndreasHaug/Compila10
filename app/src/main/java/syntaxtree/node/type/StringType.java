package node;

import symboltable.Symboltable;

public class StringType extends Type {

  public String printSyntaxtree(int indent) {
    return "TYPE:String";
  }

  public String getTypeRep() {
    return "string";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.stringType;
  }
}
