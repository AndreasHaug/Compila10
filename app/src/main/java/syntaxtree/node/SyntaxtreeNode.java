package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import symboltable.Symboltable;

public abstract class SyntaxtreeNode {

  public String indent(int indent) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (int a = 0; a < indent; a++)
      sb.append("  ");
    return sb.toString();
  }

  public abstract String printSyntaxtree(int indent);

  public symboltable.Type semanticAnalyze(Symboltable symboltable) {
    throw new IllegalAccessError("Instance of " +
				 this.getClass().getName() +
				 " is not allowed to call semanticAnalyze(Symboltable)");
  }

  public void codegen(CodeFile codefile) {
    throw new IllegalAccessError("Instance of " +
				 this.getClass().getName() +
				 " are not allowed to call codegen(Codefile)");
  }
  
  public void codegen(CodeFile codefile, CodeProcedure procedure) {
        throw new IllegalAccessError("Instance of " +
				 this.getClass().getName() +
				 " are not allowed to call codegen(Codefile, CodeProcedure)");
  }

  
}
