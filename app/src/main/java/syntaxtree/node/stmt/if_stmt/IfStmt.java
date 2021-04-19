package node;

import list.StmtList;
import symboltable.Symboltable;

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

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Type cond = e.semanticAnalyze(table);
    if (!cond.equals(symboltable.Type.boolType)) {
      throw new error.IfInvalidExpression();
    }

    /**
     * Generating a new scope for the body
     */
		
    sl.semanticListAnalyze(new Symboltable(table));

    return cond;
  }

  
  
}
