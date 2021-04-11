package symboltable;

import java.util.HashMap;

public class SymboltableUnit<T> {

  private HashMap<String, T> map;

  public SymboltableUnit() {
    map = new HashMap<>();
  }   

  public T add(String name, T instance) {
    return map.put(name, instance);
  }

  public T lookup(String name) {
      return map.get(name);
  }

    public boolean exists(String name) {
	return map.containsKey(name);
    }
}

