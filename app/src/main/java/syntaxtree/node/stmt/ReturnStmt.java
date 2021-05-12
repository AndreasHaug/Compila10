package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import symboltable.Symboltable;

public class ReturnStmt extends Stmt {

  public ReturnStmt(Exp e) {
    super(e);
  }

  public ReturnStmt() {
    super(null);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(RETURN_STMT " +
      (e != null ? e.printSyntaxtree(indent+1) : "") +
      ")";     
  }

  @Override
  public symboltable.Type stmtForWithoutTypeProcDecl(Symboltable table) {
    if (e != null) {
      throw new error.InvalidReturnType("Procedure without return type returning a value");
    }
    return super.stmtForWithoutTypeProcDecl(table);
  }

  @Override
  public symboltable.Type stmtForWithTypeProcDecl(symboltable.Type returnType,
                                                  Symboltable table) {

    /**
     * Enforce the return stmt returning a value
     */
    if (e == null) {
      throw new error.InvalidReturnType("Procedure with return type " +
                                        returnType.toString() +
                                        " cannot return void");
    }

    symboltable.Type expType = e.semanticAnalyze(table);

    if (expType == null) {
      throw new error.InvalidReturnType("Cannot find return type");
    }
    if (!expType.equals(returnType)) {
      throw new error.InvalidReturnType("Procedure with return type " +
                                        returnType.toString() +
                                        " cannot return value of type " +
                                        expType);
    }
    return expType;
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    this.table = table;
    return e == null ? null : e.semanticAnalyze(table);
  }


  @Override
  public void codegen(CodeFile codefile, CodeProcedure proc) {

    if (e != null) {
      e.pushOnStack(codefile, proc);
    }
    
    proc.addInstruction(new bytecode.instructions.RETURN());
  }

}
