package node;

import symboltable.Symboltable;

public abstract class Type implements syntaxtree.SyntaxtreeProperty {

  public String printSyntaxtree(int indent) {
    return "TYPE:";
  }

  public abstract String getTypeRep();
}
