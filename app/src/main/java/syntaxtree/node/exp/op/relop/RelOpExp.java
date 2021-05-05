package node;

import symboltable.Symboltable;

public abstract class RelOpExp extends OpExp {

  public RelOpExp(Exp l, Exp r) {
    super(l, r);
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    if (l.semanticAnalyze(table).isNumber()) {
      if (!r.semanticAnalyze(table).isNumber()) {
	throw new error.MismatchedTypes("In relational operator expression, " +
					l.toString() +
					" is of type " +
					l.semanticAnalyze(table).toString() +
					"but " +
					r.toString() +
					" is of type " +
					r.semanticAnalyze(table).toString() +
					". Both must be of numerical type");
      }
    }
    else if (l.semanticAnalyze(table).equals(symboltable.Type.stringType)) {
      if (!r.semanticAnalyze(table).equals(symboltable.Type.stringType)) {
	throw new error.MismatchedTypes("In relational operator expression, " +
					l.toString() +
					" is of type " +
					l.semanticAnalyze(table).toString() +
					"but " +
					r.toString() +
					" is of type " +
					r.semanticAnalyze(table).toString() +
					". Both must be of string type");
					
      }
    }
    
    return symboltable.Type.boolType;
  }


}
