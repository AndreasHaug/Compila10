package list;

import node.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ParamfieldDeclList extends list.ListProperty {
  
  public ParamfieldDeclList() {
    super();
  }

  public ParamfieldDeclList(ParamfieldDecl pd) {
    this.list = new LinkedList<>();
    list.add((ParamfieldDecl) pd);
  }

  public void add(ParamfieldDecl pd) {
    super.add((ParamfieldDecl) pd);
  }

  public int size() {
    return list.size();
  } 
}


