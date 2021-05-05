package symboltable;

import bytecode.type.CodeType;

public class RefType extends Type {

  private symboltable.Type referenced;

  public RefType(symboltable.Type referenced) {
    this.referenced = referenced;
  }

  @Override
  public boolean isPrimitive() {
    return false;
  }

  public String toString() {
    return "ref(" + referenced.toString() + ")";
  }
}
