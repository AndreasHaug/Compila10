package list;

import node.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class StmtList extends list.ListProperty {

  private LinkedList<Stmt> l;

  public StmtList() {
    super();
  }

  public StmtList(Stmt s) {
    this.list = new LinkedList<>();
    add(s);
  }

  public void add(Stmt s) {
    list.add((Stmt) s);
  }
}
