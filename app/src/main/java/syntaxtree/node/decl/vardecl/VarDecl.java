package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
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
  
  @Override
  public void codegen(CodeFile codefile) {
    symboltable.Type sType = table.lookupVar(name.toString()).getType();
    if (sType.isPrimitive()) {
      codefile.addVariable(name.toString());      
      codefile.updateVariable(name.toString(), sType.getRuntime());
    }
    else {
      codefile.addVariable(name.toString());
      codefile.updateVariable(name.toString(),
			      new bytecode.type.RefType(codefile
							.structNumber(sType.toString())));
    }    
  }
  
  /**
   * Doing declarations of variables inside procedure
   */
  @Override
  public void codegen(CodeFile codefile, CodeProcedure procedure) {
    symboltable.Type sType = table.lookupVar(name.toString()).getType();
    if (sType.isPrimitive()) {
      procedure.addLocalVariable(name.toString(), sType.getRuntime());
    }
    else {
      procedure.addLocalVariable(name.toString(),
				 new bytecode.type.RefType(codefile.
							   structNumber(sType.toString())));     
    }
    codefile.updateProcedure(procedure);
  }
}
