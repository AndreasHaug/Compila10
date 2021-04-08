package symboltable;

import java.util.HashMap;

public class Symboltable<T> {

  private HashMap<String, T> map;
  private Symboltable<T> outer;

  public Symboltable() {
    map = new HashMap<>();
  }
    
  public Symboltable(Symboltable outer) {
    map = new HashMap<>();
    this.outer = outer;    
  }

  public T add(String name, T instance) {
    return map.put(name, instance);
  }

  public T lookup(String name) {
    return map.containsKey(name) ?
      map.get(name) : (outer != null ? outer.lookup(name) : null);
  }
  
}
