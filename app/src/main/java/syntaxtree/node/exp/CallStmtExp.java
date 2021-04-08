package node;

public class CallStmtExp extends Exp {

  private CallStmt cs;

  public CallStmtExp(CallStmt cs) {
    this.cs = cs;
  }

  public CallStmt get() {
    return cs;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return cs.printSyntaxtree(indent);
  }
  
}
