package symboltable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Procedure implements SymboltableInstance {

  String n;
  ArrayList<symboltable.Var> args;
  symboltable.Type t;

  public Procedure(String n,
                   ArrayList<symboltable.Var> args,
                   symboltable.Type t) {
    this.n = n;
    this.args = args;
    this.t = t;
  }

  public symboltable.Type getType() {
    return t;
  }

  public int parameterCount() {
    return args.size();
  }

  public LinkedList<symboltable.Type> parameterTypes() {
    return args.stream()
      .map(x -> x.getType())
           .collect(Collectors.toCollection(LinkedList::new));    
  }
}
