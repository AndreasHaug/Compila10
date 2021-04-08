package node;

import list.ExpList;

public class CallStmt extends Stmt {

  private Name n;
  private ExpList el;
  
  public CallStmt(Name n, ExpList el) {
    super(null);
    this.n = n;
    this.el = el;
  }

  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(CALL_STMT " +
      n.printSyntaxtree(indent) +
      " " +
      el.printSyntaxtreeList(indent+1) +
      ")";
  }
}
