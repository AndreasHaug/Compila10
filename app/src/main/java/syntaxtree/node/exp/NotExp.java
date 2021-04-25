package node;

import symboltable.Symboltable;

public class NotExp extends Exp {

  private Exp e;

  public NotExp(Exp e) {
    this.e = e;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return String.format("%s(not %s)",
			 indent(indent),
			 e.printSyntaxtree(indent));
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    if (!e.semanticAnalyze(table).equals(symboltable.Type.boolType)) {
      throw new error.NotABool("Not expression must be on bool but is " + e.semanticAnalyze(table).toString());
    }
    return symboltable.Type.boolType;
  }

}
