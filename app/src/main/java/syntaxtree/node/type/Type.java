package node;

import symboltable.Symboltable;

public abstract class Type extends SyntaxtreeNode {

  public String printSyntaxtree(int indent) {
    return "TYPE:";
  }

  public abstract String getTypeRep();
}
