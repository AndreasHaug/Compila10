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

  public String toString() {
    return n.toString();
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Var variable = table.lookupVar(n.toString());
    if (variable == null) {
      throw new error.NameNotFound("Name " + n.toString() + " cannot be found");
    }
    
    // return table.lookupType(n.toString());
    return variable.getType();
  }
}
