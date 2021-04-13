package node;

import symboltable.Symboltable;

public abstract class VarDecl extends Decl {

  protected Name name;
  protected Type type;
  protected Exp exp;

  public VarDecl(Name name, Type type, Exp exp) {
    this.name = name;
    this.type = type;
    this.exp = exp;
  }

    public VarDecl(Name name) {
    this.name = name;
  }
  
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(VAR_DECL " +
      name.printSyntaxtree(indent) +
      " ";
  }

  // @Override
  // public symboltable.Type semanticAnalyze(Symboltable table) {
    // if (table.existsInScope(name.toString())) {
      //TODO: ERROR: IMPLEMENT THIS
    // }
    // table.addVar(name.toString(), null);
    //TODO: get type from exp

    // return null;
  // }
}
