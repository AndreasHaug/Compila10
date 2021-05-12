package node;

import symboltable.Symboltable;
import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.STORELOCAL;
import bytecode.instructions.STOREGLOBAL;

public class ArithOpExp extends OpExp {

  public ArithOpExp(Exp l, Exp r) {
    super(l, r);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent);
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Type lsa = l.semanticAnalyze(table);
    symboltable.Type rsa = r.semanticAnalyze(table);

    this.table = table;
    
    if (lsa == symboltable.Type.intType &&
        rsa == symboltable.Type.intType)
      return symboltable.Type.intType;    
    return symboltable.Type.floatType;    
  }
}
