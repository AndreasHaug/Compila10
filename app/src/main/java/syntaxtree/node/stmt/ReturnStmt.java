package node;

public class ReturnStmt extends Stmt {

  public ReturnStmt(Exp e) {
    super(e);
  }

  public ReturnStmt() {
    super(null);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(RETURN_STMT " +
      (e != null ? e.printSyntaxtree(indent+1) : "") +
      ")";     
  }

}
