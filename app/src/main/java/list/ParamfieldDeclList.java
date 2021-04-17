package list;

import node.*;
import symboltable.Symboltable;
import symboltable.SymboltableUnit;
import syntaxtree.SyntaxtreeProperty;

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

  // public symboltable.Symboltable toProcDeclSymboltable(Symboltable table) {
  //   return null;
  // }
  
  // public symboltable.Symboltable toRecDeclSymboltable(Symboltable table) {
  //   return null;
  // }

  /**
   * Takes the parameters and adds them to the symboltable
   */		
  public symboltable.Symboltable toSymboltable(Symboltable table) {
    /**
     * Using a table for the list of parameters
     */
    // Symboltable listTable = new Symboltable(table);

    // Symboltable instances = new Symboltable();
    // for (ParamfieldDecl pd : list) {
    for (SyntaxtreeProperty pd : list) {
      table.addType(((ParamfieldDecl) pd).getName().toString(),
		    ((ParamfieldDecl) pd).semanticAnalyze(table));
    }
    
    // return instances;
    return table;
  }

}


