package node;

import symboltable.Symboltable;

public abstract class LogOpExp extends OpExp {

  public LogOpExp(Exp l, Exp r) {
    super(l, r);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) + super.printSyntaxtree(indent+1);
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {    
    if (!l.semanticAnalyze(table).equals(symboltable.Type.boolType) ||
	!r.semanticAnalyze(table).equals(symboltable.Type.boolType)) {

      throw new error.MismatchedTypes(
				      "In logical operators || as well as &&, both operands must be of type bool");				      
    }

    return symboltable.Type.boolType;
  }
}
