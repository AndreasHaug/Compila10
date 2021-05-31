package list;

import node.*;
import symboltable.Symboltable;
import symboltable.SymboltableUnit;
import node.SyntaxtreeNode;

import java.util.ArrayList;
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
  
  public String toString() {
    return list.toString();
  }

  /**
   * Returns the parameters in the symboltable alone
   */
  public symboltable.Symboltable toSymboltable(Symboltable table) {
    Symboltable newTable = new Symboltable(false);
    for (SyntaxtreeNode pd : list) {
      newTable.addVar(((ParamfieldDecl) pd)
		      .getName()
		      .toString(),

		      new symboltable.Var(
					  ((ParamfieldDecl) pd).getName()
					  .toString(),

					  null,

					  ((ParamfieldDecl) pd).semanticAnalyze(table)));

    }

    return newTable;
  }

  public ArrayList<symboltable.Var> toList(Symboltable table) {
    ArrayList<symboltable.Var> newList = new ArrayList<>();
    for (SyntaxtreeNode pd : list) {
      newList.add(new symboltable.Var(
                                      ((ParamfieldDecl) pd).getName()
                                      .toString(),
                                      null,
                                      ((ParamfieldDecl) pd).semanticAnalyze(table)));
    }

    return newList;
  }

  /**
   * Takes the parameters and adds them to the symboltable
   */
  public symboltable.Symboltable addToSymboltable(Symboltable table) {
    /**
     * Using a table for the list of parameters
     */
    for (SyntaxtreeNode pd : list) {
      table.addVar(((ParamfieldDecl) pd)
		   .getName()
		   .toString(),
		   new symboltable.Var(
				       ((ParamfieldDecl) pd)
				       .getName()
				       .toString(),               
				       null,

				       ((ParamfieldDecl) pd).semanticAnalyze(table)));
    }
    return table;
  }

}




