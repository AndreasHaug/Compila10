package symboltable;

public class Symboltable {
    
  private SymboltableUnit<symboltable.Procedure> procs;
  private SymboltableUnit<symboltable.Type> types;
  private SymboltableUnit<symboltable.Var> vars;
  private Symboltable outer;

  public Symboltable() {
    initProcs(new SymboltableUnit<>());
    initTypes(new SymboltableUnit<>());
    initVars(new SymboltableUnit<>());
    outer = null;
  }

  public Symboltable(Symboltable outer) {
    initProcs(new SymboltableUnit<>());
    initTypes(new SymboltableUnit<>());
    initVars(new SymboltableUnit<>());
    this.outer = outer;
  }

  //lookup will return null if no occurence is found
  public SymboltableInstance lookup(String key) {
    if (procs.exists(key))
      return procs.lookup(key);
    if (types.exists(key))
      return types.lookup(key);
    if (vars.exists(key))
      return vars.lookup(key);
    if (outer == null)
      return null;    
    return outer.lookup(key);          	    
  }

  public symboltable.Type lookupType(String key) {
    if (types.exists(key)) {
      return types.lookup(key);      
    }
    if (outer == null) {
      return null;      
    }
    return outer.lookupType(key);
  }

  public symboltable.Var lookupVar(String key) {
    if (vars.exists(key)) {
      return vars.lookup(key);      
    }
    if (outer == null) {
      return null;      
    }
    return outer.lookupVar(key);
  }

  public symboltable.Procedure lookupProcedure(String key) {
    if (procs.exists(key)) {
      return procs.lookup(key);      
    }
    if (outer == null) {
      return null;      
    }
    return outer.lookupProcedure(key);
  }

  public Procedure addProcedure(String procedureName, Procedure proc) {
    if (!exists(procedureName))
      return procs.add(procedureName, proc);
    throw new error.NameAlreadyDeclared(procedureName);
  }

  public Type addType(String typeName, Type type) {
    if (!exists(typeName))
      return types.add(typeName, type);
    throw new error.NameAlreadyDeclared(typeName);
  }

  public Var addVar(String varName, Var varVal) {
    if (!exists(varName))	   
      return vars.add(varName, varVal);
    throw new error.NameAlreadyDeclared(varName);
	
  }

  public boolean existsInScope(String key) {
    return procs.existsInScope(key) ||
      types.existsInScope(key) ||
      vars.existsInScope(key);
  }

  public boolean typeExists(String typeRep) {
    return types.exists(typeRep);
  }

  private void initProcs(SymboltableUnit<Procedure> procs) {
    this.procs = procs;
    //TODO: add buildt in procedures
  }

  private void initTypes(SymboltableUnit<Type> types) {
    this.types = types;
    types.add("float", symboltable.Type.floatType);
    types.add("ref(float)", new symboltable.RefType(symboltable.Type.floatType));
    
    types.add("int", symboltable.Type.intType);
    types.add("ref(int)", new symboltable.RefType(symboltable.Type.intType));
    
    types.add("string", symboltable.Type.stringType);
    types.add("ref(string)", new symboltable.RefType(symboltable.Type.stringType));
    
    types.add("bool", symboltable.Type.boolType);
    types.add("ref(bool)", new symboltable.RefType(symboltable.Type.boolType));

  }

  private void initVars(SymboltableUnit<Var> vars) {
    this.vars = vars;
  }

  private boolean exists(String key) {
    return procs.exists(key) ||
      types.exists(key) ||
      vars.exists(key);
  }
}
