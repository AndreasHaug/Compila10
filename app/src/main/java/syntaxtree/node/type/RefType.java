package node;

import symboltable.Symboltable;

public class RefType extends Type {

  private Type t;

  public RefType(Type t) {
    this.t = t;
    ;
  }

  public String printSyntaxtree(int indent) {
    return indent(indent + 1) +
      "(" +
      super.printSyntaxtree(indent + 1) +
      "ref " +
      t.printSyntaxtree(indent + 1) +
      ")";
  }

  public String getTypeRep() {
    return "ref(" + t.getTypeRep() + ")";
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    
    return table.lookupType("ref(" +
			    t.semanticAnalyze(table).toString()  +
			    ")");
  }
}
