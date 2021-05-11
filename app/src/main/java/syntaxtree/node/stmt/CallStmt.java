package node;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import bytecode.CodeFile;
import bytecode.CodeProcedure;
import error.WrongNumberOfArguments;
import list.ExpList;
import symboltable.Symboltable;
import syntaxtree.SyntaxtreeProperty;
import bytecode.instructions.CALL;

public class CallStmt extends Stmt {

  private Name n;
  private ExpList el;
  
  public CallStmt(Name n, ExpList el) {
    super(null);
    this.n = n;
    this.el = el;
  }

  public String printSyntaxtree(int indent) {
    return indent(indent) +
      "(CALL_STMT " +
      n.printSyntaxtree(indent) +
      " " +
      el.printSyntaxtreeList(indent+1) +
      ")";
  }

  public symboltable.Type semanticAnalyze(Symboltable table) {
    symboltable.Procedure proc = table.lookupProcedure(n.toString());
    if (proc == null) {
      throw new error.NameNotFound("Call of procedure " +
				   n.toString() +
				   " which cannot be found");
    }

    int argCount = el.size();
    int parCount = proc.parameterCount();
    if (argCount != parCount) {
      throw new WrongNumberOfArguments(parCount, argCount);
    }

    //these list may be another datastructure?
    LinkedList<symboltable.Type> parameterTypes = proc.parameterTypes();
    LinkedList<symboltable.Type> argTypes = el.types(table);

    /** 
     * this is a bit simple, but it should catch the error
     * printing a good error message in the future is maybe not
     * so easy
     */
    if (!parameterTypes.equals(argTypes)) {
      throw new error
	.MismatchedTypes("In procedure call argument types not matching");
    }

    this.table = table;

    return proc.getType();
  }

  public void codegen(CodeFile codefile, CodeProcedure procedure) {
    // Iterator i = el.getList().descendingIterator();
    Iterator i = el.getList().listIterator();
    while (i.hasNext()) {
      SyntaxtreeProperty e = (SyntaxtreeProperty)  i.next();
      ((Exp) e).pushOnStack(codefile, procedure);
    }

    // for (SyntaxtreeProperty e : el.getList()) {
      // ((Exp) e).pushOnStack(codefile, procedure);
    // }
    procedure.addInstruction(new CALL(codefile.procedureNumber(n.toString())));
    codefile.updateProcedure(procedure);
  }
}
