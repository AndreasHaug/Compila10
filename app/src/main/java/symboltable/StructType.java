package symboltable;

import java.util.Collection;
import java.util.HashMap;

import bytecode.CodeFile;
import bytecode.type.CodeType;

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
  public int structNumber(CodeFile codefile, String structName) {
    return codefile.structNumber(structName);    
  }

  @Override
  public boolean isStruct() {
    return true;
  }

  public symboltable.Var getInstance(String name) {
    return instances.lookupVar(name);
  }

  public Collection asCollection() {
    return instances.varsAsCollection();
  }
  
  @Override
  public boolean isPrimitive() {
    return false;
  }
}
