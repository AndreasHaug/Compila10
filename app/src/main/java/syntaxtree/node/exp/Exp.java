package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import symboltable.Symboltable;

public abstract class Exp implements syntaxtree.SyntaxtreeProperty {

  protected Symboltable table;

  public String printSyntaxtree(int indent) {
    return "exp";
  }

  public symboltable.Type semanticAnalyze() {
    System.out.println("Semantic analyze of " + this.getClass().getName() + " not implemented");

    return null;
  }

  public boolean isStructField() {
    return false;
  }
  
  public boolean isHeapAllocation() {
    return false;
  }

  public void storeGlobal(String varName, CodeFile codefile, CodeProcedure proc) {
    System.out.println("storeGlobal() not implemented for " + this.getClass().getName());
  }

  public void storeLocal(String varName, CodeFile codefile, CodeProcedure proc) {
      System.out.println("storeLocal() not implemented for " + this.getClass().getName());
  }

  public void pushOnStack(CodeProcedure procedure) {
    System.out.println("pushOnStack() not implemented for " + this.getClass().getName());
  }

  public String getFieldName() {
    throw new IllegalAccessError();
  }
}
