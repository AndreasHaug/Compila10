package symboltable;

import node.Exp;

public class Var implements SymboltableInstance {

	String n;
	Exp e;
	Type t;

	public Var(String n, Exp e, Type t) {
		this.n = n;
		this.e = e;
		this.t = t;
	}
}
