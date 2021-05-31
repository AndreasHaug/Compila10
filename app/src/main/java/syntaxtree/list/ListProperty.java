package list;

import node.*;
import node.SyntaxtreeNode;
import symboltable.Symboltable;
import java.util.LinkedList;
import java.util.stream.Collectors;

import bytecode.CodeFile;
import bytecode.CodeProcedure;

public abstract class ListProperty {

  LinkedList<SyntaxtreeNode> list;

  public ListProperty() {
    list = new LinkedList<>();
  }

  public String indent(int indent) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (int a = 0; a < indent; a++)
      sb.append("  ");
    return sb.toString();
  }

  public void add(SyntaxtreeNode l) {
    list.add(l);
  }

  public void push(SyntaxtreeNode l) {
    list.push(l);
  }

  public LinkedList<SyntaxtreeNode> getList() {
    return list;
  }

  public int size() {
    return list.size();
  }
  
  public String printSyntaxtreeList(int indent) {    
    return list.size() > 0 ?
      list
      .stream()
      .map(x -> x.printSyntaxtree(indent+1))
      .collect(Collectors.joining())
      : "";
  }

  public void semanticListAnalyze(Symboltable table) {
    for (SyntaxtreeNode sp : list)
      sp.semanticAnalyze(table);
  }

  public void listCodegen(CodeFile codefile) {
    list.stream().forEach(x -> x.codegen(codefile));
  }

  public void listCodegen(CodeFile codefile, CodeProcedure proc) {
    list.stream().forEach(x -> x.codegen(codefile, proc));
  }

}
