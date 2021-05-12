package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.PUSHINT;
import bytecode.instructions.STOREGLOBAL;
import bytecode.instructions.STORELOCAL;
import symboltable.Symboltable;

public class Intliteral extends Literal {

  private int l;
  
  public Intliteral(int l) {
    this.l = l;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return String.format("Intliteral:%d", l);
  }

  @Override
  public Object getLiteralValue() {
    return (int) l;
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.intType;
  }

  @Override
  public void storeGlobal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new STOREGLOBAL(codefile.globalVariableNumber(varName)));
    codefile.updateProcedure(proc);
  }

  @Override
  public void storeLocal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new STORELOCAL(proc.variableNumber(varName)));
    codefile.updateProcedure(proc);
  }

  @Override
  public void pushOnStack(CodeFile codefile, CodeProcedure procedure) {
    procedure.addInstruction(new PUSHINT(l));
  }

  
  
}
