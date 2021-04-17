package node;

import list.*;
import symboltable.Symboltable;

public class WithoutTypeProcDecl extends ProcDecl {

  public WithoutTypeProcDecl(Name n,
			     ParamfieldDeclList pl,
			     DeclList dl,
			     StmtList sl) {
    super(n, pl, dl, sl);
  }
    
  @Override
  public String printSyntaxtree(int indent) {
    return
      super.printSyntaxtree(indent) +
      printSyntaxtreeMiddle(indent) +
      printSyntaxtreeTail(indent);
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    super.semanticAnalyze(table);

    dl.semanticListAnalyze(table);
    sl.stmtListForWithoutTypeProcDecl(table);
    return null;
  }
}
