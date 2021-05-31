package node;

import java.util.ArrayList;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import bytecode.instructions.NEW;
import bytecode.instructions.STOREGLOBAL;
import list.*;
import symboltable.StructType;
import symboltable.Symboltable;

public class WithoutTypeProcDecl extends ProcDecl {

  public WithoutTypeProcDecl(Name n, ParamfieldDeclList pl, DeclList dl, StmtList sl) {
    super(n, pl, dl, sl);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return super.printSyntaxtree(indent) + printSyntaxtreeMiddle(indent) + printSyntaxtreeTail(indent);
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    Symboltable procTable = new Symboltable(table);
    procTable = pl.addToSymboltable(procTable);

    ArrayList params = pl.toList(table);

    dl.semanticListAnalyze(procTable);

    table.addProcedure(n.toString(),
                       new symboltable.Procedure(n.toString(),
                                                 params,
                                                 symboltable.Type.voidType));
    
    sl.stmtListForWithoutTypeProcDecl(procTable);
    this.table = procTable;
    return null;
  }

  @Override
  public void codegen(CodeFile codefile) {

    CodeProcedure proc = new CodeProcedure(n.toString(), bytecode.type.VoidType.TYPE, codefile);
    codefile.addProcedure(n.toString());


    //special case, when to load global variables
    if (n.toString().equals("main")) {

      Symboltable global = table.getGlobal();

      for (Object a : global.varsAsCollection()) {
        symboltable.Var var = (symboltable.Var) a;
        if (var.getExp() != null) {
          if (!var.getExp().isHeapAllocation()) {
            var.getExp().storeGlobal(var.getName(), codefile, proc);	      
          }
          else {
            proc.addInstruction(new NEW(codefile.structNumber(var.getExp().toString())));
            proc.addInstruction(new STOREGLOBAL(codefile.globalVariableNumber(var.getName().toString())));
            codefile.updateProcedure(proc);
          }
        }
      }
    }
      
    pl.listCodegen(codefile, proc);
    dl.listCodegen(codefile, proc);
    sl.listCodegen(codefile, proc);

    proc.addInstruction(new bytecode.instructions.RETURN());
    codefile.updateProcedure(proc);
    
  }
}
