package node;

import symboltable.Symboltable;

public abstract class Stmt implements syntaxtree.SyntaxtreeProperty {

  protected Exp e;

  public Stmt(Exp e) {
    this.e = e;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return "stmt abstract super class not implemented";
  }

  public symboltable.Type stmtForWithoutTypeProcDecl(Symboltable table) {
    return semanticAnalyze(table);
  }

  public symboltable.Type stmtForWithTypeProcDecl(symboltable.Type returnType, Symboltable table) {
    return semanticAnalyze(table);
  }
}
