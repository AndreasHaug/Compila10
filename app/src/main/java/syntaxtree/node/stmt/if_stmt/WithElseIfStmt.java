package node;

import list.StmtList;

public class WithElseIfStmt extends IfStmt {


  private StmtList sl2;
  
  public WithElseIfStmt(Exp e, StmtList sl, StmtList sl2) {
    super(e, sl);
    this.sl2 = sl2;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) +
      indent(indent+1) +
      "(else " +
      sl2.printSyntaxtreeList(indent+1) +
      "))";      
  }

}
