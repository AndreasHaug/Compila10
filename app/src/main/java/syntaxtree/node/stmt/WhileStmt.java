package node;

import list.StmtList;
import symboltable.Symboltable;

public class WhileStmt extends Stmt {

  private StmtList sl;

  public WhileStmt(Exp e, StmtList sl) {
    super(e);
    this.sl = sl;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(WHILE_STMT " +
      e.printSyntaxtree(indent) +
      sl.printSyntaxtreeList(indent) +
      ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Type cond = e.semanticAnalyze(table);

    if (!cond.equals(symboltable.Type.boolType)) {
      throw new error.WhileInvalidExpression();
    }

    sl.semanticListAnalyze(new Symboltable(table));

    return cond;

  }

}
