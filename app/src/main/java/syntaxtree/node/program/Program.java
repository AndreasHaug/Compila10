package node;

import bytecode.CodeFile;
import list.*;
import symboltable.Symboltable;

public class Program extends SyntaxtreeNode {

  private Name name;
  private DeclList l;
  private Symboltable table;

  public Program(Name name, DeclList l) {
    this.name = name;
    this.l = l;
  }

  public String printSyntaxtree(int indent) {

    String a = (("(PROGRAM " +
	     name.printSyntaxtree(indent) +
	     " " +
	     "begin" +
	     (l.size() > 0 ? indent(indent) : "") +
	     l.printSyntaxtreeList(indent) +
	     indent(indent) +
	     "end)")
	    .replaceAll("\\s\n", "\n"))
      .replaceAll("\\s\\)", "\\)");

    return a;
  }

  @Override
  public symboltable.Type semanticAnalyze(Symboltable table) {
    this.table = table;
    l.semanticListAnalyze(table);
    return null;
  }

  @Override
  public void codegen(CodeFile codefile) {
    l.listCodegen(codefile);
  }        
}
