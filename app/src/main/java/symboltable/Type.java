package symboltable;

public abstract class Type implements SymboltableInstance {

  public static FloatType floatType = new FloatType();
  public static IntType intType = new IntType();
  public static StringType stringType = new StringType();
  public static BoolType boolType = new BoolType();
  public static RefType refType = new RefType();
  public static NullType nullType = new NullType();

  @Override
  public boolean equals(Object compare) {
    return this.toString().equals(((Type) compare).toString());
  }
}

class FloatType extends Type {
  public String toString() {
    return "float";
  }
}

class IntType extends Type {
  public String toString() {
    return "int";
  }
}

class StringType extends Type {
  public String toString() {
    return "string";
  }
}

class BoolType extends Type {
  public String toString() {
    return "bool";
  }
}

class RefType extends Type {
  public String toString() {
    return "ref";
  }
}

class NullType extends Type {
  public String toString() {
    return "null";
  }
}
