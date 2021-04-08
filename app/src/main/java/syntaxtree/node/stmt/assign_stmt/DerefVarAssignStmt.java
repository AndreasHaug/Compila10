package node;

public class DerefVarAssignStmt extends AssignStmt {

  DerefVar v;

  public DerefVarAssignStmt(Exp e, DerefVar v) {
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
