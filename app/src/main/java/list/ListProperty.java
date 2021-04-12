package list;

import node.*;
import syntaxtree.SyntaxtreeProperty;
import symboltable.Symboltable;
import java.util.LinkedList;
import java.util.stream.Collectors;

public abstract class ListProperty {

  LinkedList<SyntaxtreeProperty> list;

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

  public void add(SyntaxtreeProperty l) {
    list.add(l);
  }

  public void push(SyntaxtreeProperty l) {
    list.push(l);
  }

  public LinkedList<SyntaxtreeProperty> getList() {
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
    for (SyntaxtreeProperty sp : list)
      sp.semanticAnalyze(table);
  }

}
