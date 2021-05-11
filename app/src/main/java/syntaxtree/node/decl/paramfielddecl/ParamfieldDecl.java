package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
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
  
  public String toString() {
    return "(" + n.toString() + " : " + t.getTypeRep() + ")";
  }

  public Name getName() {
    return n;
  }

  public Type getType() {
    return t;
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    this.table = table;
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
 
  @Override
  public void codegen(CodeFile codefile, CodeProcedure proc) {
    String typeRep = this.getType().getTypeRep();
    symboltable.Type parType = table.lookupType(typeRep);

    if (parType.isPrimitive()) {
      proc.addParameter(getName().toString(), parType.getRuntime());
    }
    else {
      proc.addParameter(getName().toString(), parType.getRuntime(codefile, typeRep));
    }
  }
}
