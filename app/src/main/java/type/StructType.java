package type;

import java.util.HashMap;
import symboltable.*;

public class StructType extends Type {
 
  private String name;
  private Symboltable instances;

  public StructType(String name, Symboltable instances) {
    this.name = name;
    this.instances = instances;
  }
  
}
