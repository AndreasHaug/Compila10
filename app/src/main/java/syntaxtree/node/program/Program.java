package node;

import syntaxtree.SyntaxtreeProperty;
import list.*;
import symboltable.Symboltable;

public class Program implements SyntaxtreeProperty {

  Name name;
  DeclList l;

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

    
    
}
