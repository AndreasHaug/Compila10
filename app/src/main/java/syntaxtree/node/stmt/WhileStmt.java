package node;

import list.StmtList;

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

}
