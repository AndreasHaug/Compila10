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
  
}
