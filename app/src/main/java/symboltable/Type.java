package symboltable;

import bytecode.CodeFile;
import bytecode.type.*;

public abstract class Type implements SymboltableInstance {

  public static FloatType floatType = new FloatType();
  public static IntType intType = new IntType();
  public static StringType stringType = new StringType();
  public static BoolType boolType = new BoolType();
  public static VoidType voidType = new VoidType();
  public static NullType nullType = new NullType();

  @Override
  public boolean equals(Object compare) {
    return this.toString().equals(((Type) compare).toString());
  }

  public boolean isStruct() {
    return false;
  }

  public boolean isNumber() {
    return false;
  }

  public boolean isPrimitive() {
    return true;
  }

  public CodeType getRuntime() {
    throw new IllegalAccessError("Compound types cannot have a static type");
  }

  public int structNumber(CodeFile codefile, String structName) {
    throw new IllegalAccessError("Only StructType can call " +
				 "structNumber(CodeFile codefile, String structName)");
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

  public boolean isNumber() {
    return true;
  }

  public CodeType getRuntime() {
    return bytecode.type.FloatType.TYPE;
  }
}

class IntType extends Type {
  public String toString() {
    return "int";
  }

  public boolean isNumber() {
    return true;
  }

  public CodeType getRuntime() {
    return bytecode.type.IntType.TYPE;
  }
  
}

class StringType extends Type {
  public String toString() {
    return "string";
  }

  public CodeType getRuntime() {
    return bytecode.type.StringType.TYPE;
  }
}

class BoolType extends Type {
  public String toString() {
    return "bool";
  }

  public CodeType getRuntime() {
    return bytecode.type.BoolType.TYPE;
  }
}

class NullType extends Type {
  public String toString() {
    return "null";
  }

  public CodeType getRuntime() {
    return null;
  }
}

class VoidType extends Type {
  public String toString() {
    return "void";
  }

  public CodeType getRuntime() {
    return bytecode.type.VoidType.TYPE;
  }
}
