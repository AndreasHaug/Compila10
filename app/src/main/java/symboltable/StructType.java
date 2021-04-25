package symboltable;

import java.util.HashMap;

public class StructType extends symboltable.Type {
 
  private String name;
  private symboltable.Symboltable instances;

  public StructType(String name, symboltable.Symboltable instances) {
    this.name = name;
    this.instances = instances;
  }

  @Override
  public String toString() {
    return name;
  }

  @Override
  public boolean isStruct() {
    return true;
  }

  public symboltable.Var getInstance(String name) {
    return instances.lookupVar(name);
  }
}
