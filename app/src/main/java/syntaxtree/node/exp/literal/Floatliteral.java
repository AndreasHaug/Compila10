package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.PUSHFLOAT;
import bytecode.instructions.STOREGLOBAL;
import bytecode.instructions.STORELOCAL;
import symboltable.Symboltable;

public class Floatliteral extends Literal {

  private float l;
  
  public Floatliteral(float l) {
    this.l = l;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return String.format("Floatliteral:%f", l);
  }

  @Override
  public Object getLiteralValue() {
    return (float) l;
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    return symboltable.Type.floatType;
  }

  @Override
  public void storeGlobal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new PUSHFLOAT(l));
    proc.addInstruction(new STOREGLOBAL(codefile.globalVariableNumber(varName)));
    codefile.updateProcedure(proc);
  }

  @Override
  public void storeLocal(String varName, CodeFile codefile, CodeProcedure proc) {
    proc.addInstruction(new PUSHFLOAT(l));
    proc.addInstruction(new STORELOCAL(proc.variableNumber(varName)));
    codefile.updateProcedure(proc);
  }

  @Override
  public void pushOnStack(CodeProcedure procedure) {
    procedure.addInstruction(new PUSHFLOAT(l));
  }
}
