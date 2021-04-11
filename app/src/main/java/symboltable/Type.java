package symboltable;

public abstract class Type implements SymboltableInstance {

    public static FloatType floatType = new FloatType();
    public static IntType intType = new IntType();
    public static StringType stringType = new StringType();
    public static BoolType boolType = new BoolType();
    public static RefType refType = new RefType();  
}

class FloatType extends Type {}
class IntType extends Type {}
class StringType extends Type {}
class BoolType extends Type {}
class RefType extends Type {}
