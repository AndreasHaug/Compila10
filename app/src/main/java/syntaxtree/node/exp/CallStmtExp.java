package node;

import symboltable.Symboltable;
import bytecode.CodeFile;
import bytecode.CodeProcedure;

public class CallStmtExp extends Exp {

  private CallStmt cs;

  public CallStmtExp(CallStmt cs) {
    this.cs = cs;
  }

  public CallStmt get() {
    return cs;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return cs.printSyntaxtree(indent);
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return cs.semanticAnalyze(table);
  }

  @Override
  public void codegen(CodeFile codefile, CodeProcedure procedure) {
    cs.codegen(codefile, procedure);
  }

  @Override
  public void pushOnStack(CodeFile codefile, CodeProcedure procedure) {
    this.codegen(codefile, procedure);    
  }
}
