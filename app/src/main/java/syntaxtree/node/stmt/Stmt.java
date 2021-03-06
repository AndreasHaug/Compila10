package node;

import symboltable.Symboltable;

public abstract class Stmt extends SyntaxtreeNode {

  protected Exp e;
  protected Symboltable table;

  public Stmt(Exp e) {
    this.e = e;
  }

  @Override
  public abstract String printSyntaxtree(int indent);

  public symboltable.Type stmtForWithoutTypeProcDecl(Symboltable table) {
    return semanticAnalyze(table);
  }

  public symboltable.Type stmtForWithTypeProcDecl(symboltable.Type returnType, Symboltable table) {
    return semanticAnalyze(table);
  }
}
