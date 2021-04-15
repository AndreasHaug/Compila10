package node;

import list.*;
import symboltable.Symboltable;

public abstract class ProcDecl extends Decl {

  protected Name n;
  protected ParamfieldDeclList pl;
  protected boolean withType;
  protected DeclList dl;
  protected StmtList sl;

  public ProcDecl(Name n,
		  ParamfieldDeclList pl,
		  DeclList dl,
		  StmtList sl) {
    this.n = n;
    this.pl = pl;
    this.dl = dl;
    this.sl = sl;
  }

  protected String printSyntaxtreeTail(int indent) {
    return
      dl.printSyntaxtreeList(indent) +
      sl.printSyntaxtreeList(indent) +
      (dl.size() > 0 ||
       sl.size() > 0 ?
       indent(indent) + "end)" : " end)");
  }

  protected String printSyntaxtreeMiddle(int indent) {
    return
      pl.printSyntaxtreeList(indent) +
      (pl.size() > 0 ||
       dl.size() > 0 ?
       indent(indent) + "begin" :
       " begin");
  }
  
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(PROC_DECL " +
      n.printSyntaxtree(indent);
  }

  // @Override
  // public symboltable.Type semanticAnalyse(Symboltable table) {

    // return null;
  // }
}
