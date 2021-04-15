package node;

import list.*;
import symboltable.Symboltable;
import symboltable.SymboltableUnit;
import type.StructType;

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

    StructType stype = new StructType(n.toString(), structInstances);
    table.addType(n.toString(), stype);
    
    return stype;
  }
}
