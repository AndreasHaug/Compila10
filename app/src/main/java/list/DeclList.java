package list;

import node.*;
import syntaxtree.SyntaxtreeProperty;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class DeclList extends list.ListProperty {

  protected LinkedList<Decl> decllist = new LinkedList<>();

  private boolean isIn = false;
  
  public DeclList() {
    super();
  }

  // public DeclList(LinkedList<Decl> l) {
    // this.list = l;
  // }

  public DeclList(DeclList dl, boolean isIn) {
    this.list = dl.getDeclList();
    this.isIn = isIn;
  }

  public DeclList(DeclList dl) {
    this.list = dl.getDeclList();
  }

  public LinkedList<SyntaxtreeProperty> getDeclList() {
    return getList();
  }
 
  public void add(Decl l) {
    super.add((Decl) l);
  }

  public void push(Decl l) {
    super.push((Decl) l);
  }

  public int size() {
    return list.size();
  }

  public void setIn() {
    isIn = true;
  }

  @Override
  public String printSyntaxtreeList(int indent) {
    return super.printSyntaxtreeList(indent) +
      (isIn ?
       (list.size() > 0 ?
	indent(indent) + "in"
	: " in")
       : "");
  }


  

  


}
