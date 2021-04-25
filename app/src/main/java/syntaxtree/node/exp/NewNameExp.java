package node;

import symboltable.Symboltable;

public class NewNameExp extends Exp {

  private Name n;

  public NewNameExp(Name n) {
    this.n = n;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return
      indent(indent) +
      "(NEW " +
      n.printSyntaxtree(indent) +
      ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {

    // System.out.println(n.toString());

    if (table.lookupType(n.toString()) == null) {
      throw new error
	.NameNotFound("Name " + n.toString() + " cannot be found");      
    }
    else {
      return table.lookupType(n.toString());      
    }
  }

  
}
