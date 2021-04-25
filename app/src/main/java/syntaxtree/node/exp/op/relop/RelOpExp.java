package node;

import symboltable.Symboltable;

public abstract class RelOpExp extends OpExp {

  public RelOpExp(Exp l, Exp r) {
    super(l, r);
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    if (!l.semanticAnalyze(table).equals(symboltable.Type.boolType) ||
	!r.semanticAnalyze(table).equals(symboltable.Type.boolType)) {

      throw new error.MismatchedTypes("In relational operators, both operands must be of type bool");				      
    }
    return symboltable.Type.boolType;
  }
}
