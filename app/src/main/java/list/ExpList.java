package list;

import node.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ExpList extends ListProperty {

  public ExpList() {
    super();
  }

  public ExpList(Exp e) {
    list = new LinkedList<>();
    add((Exp) e);
  }

  public void add(Exp e) {
    super.add((Exp) e);
  }

  @Override
  public String printSyntaxtreeList(int indent) {    
    return list.size() > 0 ?
      list
      .stream()
      .map(x -> x.printSyntaxtree(indent+1) + " ")
      .collect(Collectors.joining())
      : "";
  }
}
