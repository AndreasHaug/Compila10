package node;

import symboltable.Symboltable;

public class WithTypeAssignedVarDecl extends VarDecl {

  public WithTypeAssignedVarDecl(Name name, Type type, Exp exp) {
    super(name, type, exp);
  }


  public String printSyntaxtree(int indent) {
    return
      super.printSyntaxtree(indent) +
      type.printSyntaxtree(indent) +
      " (" +
      exp.printSyntaxtree(indent) +
      "))";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    if (table.existsInScope(name.toString())) {
      throw new error.NameAlreadyDeclared(name.toString());
    }

    /**
     * type declared
     */
    String typeRef = type.getTypeRep();
    symboltable.Type declType = table.lookupType(typeRef);  

    if (declType == null) {
      throw new error.NoTypeExists(typeRef);
    }

    /**
     * type of expression
     */
    symboltable.Type expType = exp.semanticAnalyze(table);

    if (!declType.equals(expType)) {
      throw new error.MismatchedTypes("Cannot assign " +
				      expType.toString() +
				      " to variable declared as " +
					declType.toString());
    }

    table.addVar(name.toString(),
		 new symboltable.Var(name.toString(), exp, expType));

    return declType;
  }
  
}
