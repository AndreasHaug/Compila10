package node;

import list.*;

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

  // @Override
  // public symboltable.Type semanticAnalyse(Symboltable table) {
    // this one must have a return stmt as the last stmt
    // return null;
  // }  
}
