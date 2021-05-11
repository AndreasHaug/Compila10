package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import list.StmtList;
import symboltable.Symboltable;

import bytecode.instructions.NOP;
import bytecode.instructions.JMP;
import bytecode.instructions.JMPTRUE;
import bytecode.instructions.JMPFALSE;

public abstract class IfStmt extends Stmt {

  protected StmtList sl;
  
  public IfStmt(Exp e, StmtList sl) {
    super(e);
    this.sl = sl;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(IF_STMT " +
      e.printSyntaxtree(indent+1)+
      sl.printSyntaxtreeList(indent);      
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Type cond = e.semanticAnalyze(table);
    if (!cond.equals(symboltable.Type.boolType)) {
      throw new error.IfInvalidExpression();
    }

    /**
     * Generating a new scope for the body
     */
		
    sl.semanticListAnalyze(new Symboltable(table));

    return cond;
  }

  @Override
  public void codegen(CodeFile codefile, CodeProcedure procedure) {
    e.pushOnStack(codefile, procedure);

    int jmptrue = procedure.addInstruction(new NOP());
    int jmpfalse = procedure.addInstruction(new NOP());

    int ifStart = procedure.addInstruction(new NOP());
    sl.listCodegen(codefile, procedure);
    int ifEnd = procedure.addInstruction(new NOP());

    procedure.replaceInstruction(jmptrue, new JMPTRUE(ifStart));
    procedure.replaceInstruction(jmpfalse, new JMP(ifEnd));

    codefile.updateProcedure(procedure);
  }  
}
