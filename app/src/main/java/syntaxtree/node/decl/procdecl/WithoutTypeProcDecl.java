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
    Symboltable procTable = new Symboltable(table);
    procTable = pl.addToSymboltable(procTable);

    Symboltable params = pl.toSymboltable(table);

    
    dl.semanticListAnalyze(procTable);
    sl.stmtListForWithoutTypeProcDecl(procTable);

    
    table.addProcedure(n.toString(),
		       new symboltable.Procedure(n.toString(),
						 params,
						 symboltable.Type.voidType));

    return null;
  }
}
