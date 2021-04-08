package node;

public abstract class AssignStmt extends Stmt {
  
  public AssignStmt(Exp e) {
    super(e);
  }
  
  @Override
  public String printSyntaxtree(int indent) {
    return
      indent(indent) +
      "(ASSIGN_STMT "; 
  }
}
