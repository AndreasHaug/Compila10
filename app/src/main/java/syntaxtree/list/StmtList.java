package list;

import node.*;
import symboltable.Symboltable;

import java.util.LinkedList;
import java.util.stream.Collectors;

public class StmtList extends list.ListProperty {

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

  public void stmtListForWithoutTypeProcDecl(Symboltable table) {
    list.stream()
      .forEach(x -> ((Stmt) x).stmtForWithoutTypeProcDecl(table));
  }

  public void stmtListForWithTypeProcDecl(symboltable.Type returnType, Symboltable table) {
    list.stream()
      .forEach(x -> ((Stmt) x).stmtForWithTypeProcDecl(returnType, table));
  }
}
