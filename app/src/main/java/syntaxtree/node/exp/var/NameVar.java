package node;

import symboltable.Symboltable;

public class NameVar extends Var {

  private Name n;

  public NameVar(Name n) {
    this.n = n;
  }

  public String printSyntaxtree(int indent) {
    return n.printSyntaxtree(indent);
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    return table.lookupType(n.toString());
  }
}
