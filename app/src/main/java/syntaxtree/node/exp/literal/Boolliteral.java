package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.PUSHBOOL;
import bytecode.instructions.STOREGLOBAL;
import bytecode.instructions.STORELOCAL;
import symboltable.Symboltable;

public class Boolliteral extends Literal {

  private boolean b;
  
  public Boolliteral(boolean b) {
    this.b = b;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return Boolean.toString(b);
  }

  @Override
  public Object getLiteralValue() {
    return (boolean) b;
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.boolType;
  }

  @Override
  public void storeGlobal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new STOREGLOBAL(codefile.globalVariableNumber(varName)));
  }

  @Override
  public void storeLocal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new STORELOCAL(proc.variableNumber(varName)));
    codefile.updateProcedure(proc);
  }

  @Override
  public void pushOnStack(CodeFile codefile, CodeProcedure procedure) {
    procedure.addInstruction(new PUSHBOOL(b));
  }
}
