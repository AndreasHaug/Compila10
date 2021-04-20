package node;

import list.ExpList;
import symboltable.Symboltable;

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

  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Procedure proc = table.lookupProcedure(n.toString());
    if (proc == null) {
      throw new error.NameNotFound("Call of procedure " +
				   n.toString() +
				   " which cannot be found");
    }

    return proc.getType();
  }
}
