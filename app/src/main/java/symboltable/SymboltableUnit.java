package symboltable;

import java.util.HashMap;
import list.ParamfieldDeclList;

public class SymboltableUnit<T> {

  private HashMap<String, T> map;

  public SymboltableUnit() {
    map = new HashMap<>();
  }

  public SymboltableUnit(ParamfieldDeclList l) {
    
  }

  public T add(String name, T instance) {
    return map.put(name, instance);
  }

  public T lookup(String name) {
      return map.get(name);
  }

  public boolean existsInScope(String name) {
    return map.containsKey(name);
  }

  public boolean exists(String name) {
    return map.containsKey(name);
  }
}

