package symboltable;

import java.util.ArrayList;

public class Procedure implements SymboltableInstance {

    String n;
    symboltable.Var[] args;
    Type t;

    public Procedure(String n) {
	this.n = n;
	this.args = args;
	this.t = t;
    }	
}
