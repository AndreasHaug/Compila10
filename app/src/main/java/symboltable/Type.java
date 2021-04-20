package symboltable;

public abstract class Type implements SymboltableInstance {

  public static FloatType floatType = new FloatType();
  public static IntType intType = new IntType();
  public static StringType stringType = new StringType();
  public static BoolType boolType = new BoolType();
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

  /**
   * Ensure float can be assigned with intliteral
   */
  @Override
  public boolean equals(Object compare) {
    return
      super.equals(compare) ||
      ((Type) compare).toString().equals("int");
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

class NullType extends Type {
  public String toString() {
    return "null";
  }
}

class voidType extends Type {
  public String toString() {
    return "void";
  }
}
