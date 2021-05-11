package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import list.*;
import symboltable.Symboltable;

public class WithTypeProcDecl extends ProcDecl {

  private Type t;

  public WithTypeProcDecl(Name n,
			  ParamfieldDeclList pl,
			  Type t,
			  DeclList dl,
			  StmtList sl) {
    super(n, pl, dl, sl);
    this.t = t;
  }

  @Override
  protected String printSyntaxtreeMiddle(int indent) {
    return
      pl.printSyntaxtreeList(indent) +
      (pl.size() > 0 ? indent(indent) : "") +
      t.printSyntaxtree(indent) +
      (sl.size() > 0 ||
       dl.size() > 0 ?
       indent(indent) + "begin" :
       " begin");
  }
  
  @Override
  public String printSyntaxtree(int indent) {
    return
      super.printSyntaxtree(indent) +
      " " +
      printSyntaxtreeMiddle(indent) +
      printSyntaxtreeTail(indent);
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    /**
     * A new scope for the procedure
     */
    Symboltable procTable = new Symboltable(table);

    /**
     * The actual parameters represented
     */
    Symboltable params = pl.toSymboltable(table);
    /**
     * The parameters will also have to be in the
     * scope of the procedure		
     */
    procTable = pl.addToSymboltable(procTable);
    
    dl.semanticListAnalyze(procTable);
    sl.stmtListForWithTypeProcDecl(procTable.lookupType(t.getTypeRep()), procTable);
    

    table.addProcedure(n.toString(),
		       new symboltable.Procedure(n.toString(),
						 params,
						 t.semanticAnalyze(table)));

    this.table = procTable;
    return null;
  }

  @Override
  public void codegen(CodeFile codefile) {
    symboltable.Type sType = table.lookupProcedure(n.toString()).getType();

    CodeProcedure proc =  sType.isPrimitive() ?
      new CodeProcedure(n.toString(),
				 table.lookupProcedure(n.toString())
				 .getType()
				 .getRuntime(),
				 codefile)
      :   
      new CodeProcedure(n.toString(),
			       table.lookupProcedure(n.toString())
			       .getType()
			       .getRuntime(codefile, t.getTypeRep()),
			       codefile);
                
    codefile.addProcedure(n.toString());
    pl.listCodegen(codefile, proc);
    dl.listCodegen(codefile, proc);
    sl.listCodegen(codefile, proc);
    codefile.updateProcedure(proc);
  }
}
