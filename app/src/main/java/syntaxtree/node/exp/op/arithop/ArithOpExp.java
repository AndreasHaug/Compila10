package node;

import symboltable.Symboltable;

public class ArithOpExp extends OpExp {

  public ArithOpExp(Exp l, Exp r) {
    super(l, r);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent);
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {    
    if (l.semanticAnalyze(table) == symboltable.Type.intType &&
	r.semanticAnalyze(table) == symboltable.Type.intType)
      return symboltable.Type.intType;    
    return symboltable.Type.floatType;    
  }
}
