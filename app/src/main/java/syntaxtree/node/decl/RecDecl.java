package node;

import list.*;
import symboltable.Symboltable;
import symboltable.SymboltableUnit;
import symboltable.StructType;

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

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    if (table.existsInScope(n.toString())) {
      throw new error.NameAlreadyDeclared(n.toString());
    }

    Symboltable structInstances = l.toSymboltable(new Symboltable(table));

    symboltable.StructType stype = new StructType(n.toString(), structInstances);
    symboltable.RefType structRefType = new symboltable.RefType(stype);
    table.addType(n.toString(), stype);
    table.addType("ref(" + n.toString() + ")", structRefType);
    
    return stype;
  }
}
