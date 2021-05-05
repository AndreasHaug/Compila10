package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.PUSHSTRING;
import bytecode.instructions.STOREGLOBAL;
import bytecode.instructions.STORELOCAL;
import symboltable.Symboltable;

public class Stringliteral extends Literal {

  private String s;
  
  public Stringliteral(String s) {
    this.s = s;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return "Stringliteral:" + "\"" + s + "\"";
  }

  @Override
  public Object getLiteralValue() {
    return (String) s;
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.stringType;
  }

  @Override
  public void storeGlobal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new PUSHSTRING(proc.addStringConstant(s)));
    proc.addInstruction(new STOREGLOBAL(codefile.globalVariableNumber(varName)));
  }

  @Override
  public void storeLocal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new PUSHSTRING(codefile.addStringConstant(s)));
    proc.addInstruction(new STORELOCAL(proc.variableNumber(varName)));
  }

  @Override
  public void pushOnStack(CodeProcedure procedure) {
    procedure.addInstruction(new PUSHSTRING(procedure.addStringConstant(s)));		
  }
}
