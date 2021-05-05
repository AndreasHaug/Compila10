package syntaxtree;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import symboltable.Symboltable;

public interface SyntaxtreeProperty {

  public default String indent(int indent) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (int a = 0; a < indent; a++)
      sb.append("  ");
    return sb.toString();
  }

  public String printSyntaxtree(int indent);

  public default symboltable.Type semanticAnalyze(Symboltable symboltable) {
    System.out.println("Semantic analyze of " + this.getClass().getName() + " not implemented");
    return null;
  }

  public default void codegen(CodeFile codefile) {
    System.out.println("Codegen(codefile) of " + this.getClass().getName() + "not implemented");
  }

  public default void codegen(CodeFile codefile, CodeProcedure procedure) {
    // System.out.println("codegen(table, codefile, codeprocedure)" + this.getClass().getName() +
		       // "not implemented");
    // throw new IllegalAccessError();
    System.out.println("Codegen(codefile, codeprocedure) of " + this.getClass().getName() + "not implemented");
  }

  
}
