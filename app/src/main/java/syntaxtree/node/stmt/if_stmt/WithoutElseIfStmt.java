package node;

import list.StmtList;

public class WithoutElseIfStmt extends IfStmt {
  
  public WithoutElseIfStmt(Exp e, StmtList sl) {
    super(e, sl);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) + ")";
  }
  
}
