package node;

import bytecode.CodeFile;
import symboltable.Symboltable;

public class NotAssignedVarDecl extends VarDecl {

  public NotAssignedVarDecl(Name name, Type type) {
    super(name);
    this.type = type;
    this.exp = null;
  }

  public String printSyntaxtree(int indent) {
    return (super.printSyntaxtree(indent) +      
	    type.printSyntaxtree(indent)) + ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    this.table = table;
    if (table.existsInScope(name.toString())) {
      throw new error.NameAlreadyDeclared(name.toString());
    }
    
    String typeRef = type.getTypeRep();        
    symboltable.Type declType = table.lookupType(typeRef);
    if  (declType == null)
      throw new error.NoTypeExists(typeRef);
    
    table.addVar(name.toString(),
		 new symboltable.Var(name.toString(), null, declType));
    return declType;
  }
}
