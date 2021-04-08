package node;

import list.*;

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
}
