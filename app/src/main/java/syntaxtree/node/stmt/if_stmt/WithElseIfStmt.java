package node;

import list.StmtList;
import symboltable.Symboltable;

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

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Type cond = super.semanticAnalyze(table);
    sl2.semanticListAnalyze(new Symboltable(table));

    return cond;
  }
  

}
