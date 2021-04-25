package node;

import symboltable.Symboltable;

public class ParamfieldDecl extends Decl {

  private Name n;
  private Type t;

  public ParamfieldDecl(Name n, Type t) {
    this.n = n;
    this.t = t;
  }

  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(PARAMFIELD_DECL " +
      n.printSyntaxtree(indent) +
      " " +
      t.printSyntaxtree(indent) +
      ")";
  }

  public Name getName() {
    return n;
  }

  public Type getType() {
    return t;
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    /**
     * Enforce that all name in a list of parameters are unique
     */
    if (table.lookup(n.toString()) != null) {
      throw new error.NameAlreadyDeclared(n.toString());
    }

    /**
     * Ensure that the type exists
     */
    symboltable.Type checked = table.lookupType(t.getTypeRep());   
    if (checked == null) {
      throw new error.NoTypeExists(t.getTypeRep());
    }
    
    return checked;
  }

  public String toString() {
    return "(" + n.toString() + " : " + t.getTypeRep() + ")";
  }
}
