package symboltable;

import node.Exp;

public class Var implements SymboltableInstance {

  private String n;
  private Exp e;
  private Type t;

  public Var(String n, Exp e, Type t) {
    this.n = n;
    this.e = e;
    this.t = t;
  }

  public String getName() {
    return n;
  }

  public symboltable.Type getType() {
    return t;
  }

  public Exp getExp() {
    return e;
  }

  
}
