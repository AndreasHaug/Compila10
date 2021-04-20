package symboltable;

import java.util.ArrayList;

public class Procedure implements SymboltableInstance {

  String n;
  // symboltable.Var[] args;
  Symboltable args;
  symboltable.Type t;

  public Procedure(String n,
		   Symboltable args,
		   symboltable.Type t) {
    this.n = n;
    this.args = args;
    this.t = t;
  }


  public symboltable.Type getType() {
    return t;
  }
}
