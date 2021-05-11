package node;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.NOP;
import bytecode.instructions.JMP;
import bytecode.instructions.JMPTRUE;
import bytecode.instructions.JMPFALSE;
import list.StmtList;
import symboltable.Symboltable;

public class WithElseIfStmt extends IfStmt {

  private StmtList sl2;
  
  public WithElseIfStmt(Exp e, StmtList sl, StmtList sl2) {
    super(e, sl);
    this.sl2 = sl2;
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) +
      indent(indent+1) +
      "(else " +
      sl2.printSyntaxtreeList(indent+1) +
      "))";      
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Type cond = super.semanticAnalyze(table);
    sl2.semanticListAnalyze(new Symboltable(table));
    this.table = table;
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

    int elseStart = procedure.addInstruction(new NOP());
    sl2.listCodegen(codefile, procedure);
    int elseEnd = procedure.addInstruction(new NOP());

    procedure.replaceInstruction(jmptrue, new JMPTRUE(ifStart  + 1));
    procedure.replaceInstruction(jmpfalse, new JMP(elseStart + 1));
    
    procedure.replaceInstruction(ifEnd, new JMP(elseEnd + 1));
    procedure.replaceInstruction(elseEnd, new JMP(elseEnd + 1));

    codefile.updateProcedure(procedure);    
  }
}
