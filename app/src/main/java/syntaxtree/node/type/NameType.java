package node;

import symboltable.Symboltable;

public class NameType extends Type {

  private Name n;
  private Symboltable table;

  public NameType(Name n) {
    this.n = n;
  }

  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) + n.printSyntaxtree(indent);
  }

  public String getTypeRep() {
    return n.toString();
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return table.lookupType(n.toString());
  }
}
