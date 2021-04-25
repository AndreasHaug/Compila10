package symboltable;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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

  public int size() {
    return map.size();
  }

  public Collection asCollection() {
    return map.values();
  }

  public Stream<T> stream() {
    return map.values().stream();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (Map.Entry v : map.entrySet()) {
      sb.append(v.getKey() + ", " + v.getValue());
    }
    sb.append("]");
    return sb.toString();
  }
}

