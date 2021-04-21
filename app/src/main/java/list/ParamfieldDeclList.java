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

  /**
   * Takes the parameters and adds them to the symboltable
   */		
  public symboltable.Symboltable toSymboltable(Symboltable table) {
    /**
     * Using a table for the list of parameters
     */
    for (SyntaxtreeProperty pd : list) {
      table.addVar(((ParamfieldDecl) pd).getName().toString(),
		   new symboltable.Var(
				       ((ParamfieldDecl) pd).getName().toString(),
				       null,
				       ((ParamfieldDecl) pd).semanticAnalyze(table)));
    }    
    return table;
  }

}


