package node;

import list.StmtList;

public abstract class IfStmt extends Stmt {

  protected StmtList sl;
  
  public IfStmt(Exp e, StmtList sl) {
    super(e);
    this.sl = sl;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(IF_STMT " +
      e.printSyntaxtree(indent+1)+
      sl.printSyntaxtreeList(indent);      
  }
 
  
}
