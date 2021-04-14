package type;

import java.util.HashMap;

public class StructType extends symboltable.Type {
 
  private String name;
  private symboltable.SymboltableUnit<symboltable.Type> instances;
  // private Symboltable instances;

  public StructType(String name, symboltable.SymboltableUnit<symboltable.Type> instances) {
    this.name = name;
    this.instances = instances;
  }

  @Override
  public String toString() {
    return name;
  }
  
}
