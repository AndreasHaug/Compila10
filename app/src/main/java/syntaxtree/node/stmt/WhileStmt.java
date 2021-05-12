package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import list.StmtList;
import symboltable.Symboltable;

import bytecode.instructions.NOP;
import bytecode.instructions.JMP;
import bytecode.instructions.JMPTRUE;
import bytecode.instructions.JMPFALSE;

public class WhileStmt extends Stmt {

  private StmtList sl;

  public WhileStmt(Exp e, StmtList sl) {
    super(e);
    this.sl = sl;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(WHILE_STMT " +
      e.printSyntaxtree(indent) +
      sl.printSyntaxtreeList(indent) +
      ")";
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Type cond = e.semanticAnalyze(table);

    if (!cond.equals(symboltable.Type.boolType)) {
      throw new error.WhileInvalidExpression();
    }

    sl.semanticListAnalyze(new Symboltable(table));

    return cond;

  }

  @Override
  public void codegen(CodeFile codefile, CodeProcedure procedure) {
    e.pushOnStack(codefile, procedure);

    int jmpfalse = procedure.addInstruction(new NOP());

    int whileStart = procedure.addInstruction(new NOP());
    sl.listCodegen(codefile, procedure);
    e.pushOnStack(codefile, procedure);
    int jmptrue = procedure.addInstruction(new JMPTRUE(whileStart));
    int whileEnd = procedure.addInstruction(new NOP());

    procedure.replaceInstruction(jmpfalse, new JMPFALSE(whileEnd));
    
  }    
}
