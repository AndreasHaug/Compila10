package symboltable;

import java.util.HashMap;

public class Symboltable {
  
  private HashMap<String, SymboltableInstance> map;
  private Symboltable outer;

  public Symboltable(Symboltable outer) {
    map = new HashMap<>();
    this.outer = outer;
    
  }

  public SymboltableInstance add(String name, SymboltableInstance instance) {
    return map.put(name, instance);
  }

  public SymboltableInstance lookup(String name) {
    return map.containsKey(name) ?
      map.get(name) : (outer != null ? outer.lookup(name) : null);
  }
  
}
