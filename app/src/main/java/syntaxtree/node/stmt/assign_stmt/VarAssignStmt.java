package node;

public class VarAssignStmt extends AssignStmt {

  Var v;

  public VarAssignStmt(Exp e, Var v) {
    super(e);
    this.v = v;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) +
      v.printSyntaxtree(indent+1) +
      " " +
      e.printSyntaxtree(indent+1) +
      ")";
  }


}
