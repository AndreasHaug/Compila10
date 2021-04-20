package node;

import symboltable.Symboltable;

public class VarAssignStmt extends AssignStmt {

  Var v;

  public VarAssignStmt(Exp e, Var v) {
    super(e);
    this.v = v;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) +
      v.printSyntaxtree(indent+1) +
      " " +
      e.printSyntaxtree(indent+1) +
      ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {

    symboltable.Type varType = v.semanticAnalyze(table);
    symboltable.Type expType = e.semanticAnalyze(table);

    if (!varType.equals(expType)) {
      throw new error.MismatchedTypes("Variable of type " +
				      varType.toString() +
				      " cannot be assigned to value of type " +
				      expType.toString());
    }

    return expType;
  }


}
