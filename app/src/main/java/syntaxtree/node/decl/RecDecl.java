package node;

import list.*;

public class RecDecl extends Decl {

  private Name n;
  private ParamfieldDeclList l;

  public RecDecl(Name n, ParamfieldDeclList l) {
    this.n = n;
    this.l = l;
  }

  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(REC_DECL " +
      n.printSyntaxtree(indent).trim() +
       l.printSyntaxtreeList(indent) +
      ")";
  }
}
