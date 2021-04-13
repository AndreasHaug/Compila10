package node;

import symboltable.Symboltable;

public abstract class Exp implements syntaxtree.SyntaxtreeProperty {

  public String printSyntaxtree(int indent) {
    return "exp";
  }

  public symboltable.Type semanticAnalyze() {
    System.out.println("Semantic analyze of " + this.getClass().getName() + " not implemented");

    return null;
  }
}
