package syntaxtree;

import node.*;

public class Syntaxtree implements SyntaxtreeProperty {

  Program program;

  public Syntaxtree(Program program) {
    this.program = program;
  }

  public String printSyntaxtree(int indent) {
    return program.printSyntaxtree(indent);
  }
}
