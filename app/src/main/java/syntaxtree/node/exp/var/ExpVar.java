package node;

import symboltable.Symboltable;

public class ExpVar extends Var {

  private Exp e;
  private Name n;

  public ExpVar(Exp e, Name n) {
    this.e = e;
    this.n = n;
  }

  public String printSyntaxtree(int indent) {
    return
      "(. " +
      e.printSyntaxtree(indent) +
      " " +
      n.printSyntaxtree(indent) +
      ")";
  }

  public String toString() {
    return e.toString() + n.toString();
  }

  // @Override
  // public symboltable.Type semanticAnalyze(Symboltable table) {
    // System.out.println("Exp.Var: this is not determined yet.");
    // return null;
  // }
}
