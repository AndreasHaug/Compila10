package syntaxtree;

import node.*;

public class Syntaxtree extends SyntaxtreeNode {

  Program program; //the root node of the ast

  public Syntaxtree(Program program) {
    this.program = program;
  }

  public String printSyntaxtree(int indent) {
    return program.printSyntaxtree(indent);
  }
}
