package node;

import symboltable.Symboltable;
import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.STORELOCAL;
import bytecode.instructions.STOREGLOBAL;

public class ArithOpExp extends OpExp {

  public ArithOpExp(Exp l, Exp r) {
    super(l, r);
  }


  
  
  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent);
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {    
    if (l.semanticAnalyze(table) == symboltable.Type.intType &&
	r.semanticAnalyze(table) == symboltable.Type.intType)
      return symboltable.Type.intType;    
    return symboltable.Type.floatType;    
  }

  // private void pushOnStackAndAddInstruction(CodeProcedure procedure) {
  //   r.pushOnStack(procedure);
  //   l.pushOnStack(procedure);
  //   this.addOperatorInstruction(procedure);
  // }

  // public void storeLocal(String varName, CodeFile codefile, CodeProcedure procedure) {
  //   pushOnStackAndAddInstruction(procedure);
  //   procedure.addInstruction(new STORELOCAL(procedure.variableNumber(varName)));
  //   codefile.updateProcedure(procedure);    
  // }

  // public void storeGlobal(String varName, CodeFile codefile, CodeProcedure procedure) {
  //   pushOnStackAndAddInstruction(procedure);
  //   procedure.addInstruction(new STOREGLOBAL(procedure.globalVariableNumber(varName)));
  //   codefile.updateProcedure(procedure);
  // }
}
