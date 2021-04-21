package symboltable;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Symboltable {
    
  private SymboltableUnit<symboltable.Procedure> procs;
  private SymboltableUnit<symboltable.Type> types;
  private SymboltableUnit<symboltable.Var> vars;
  private Symboltable outer;

  public Symboltable(boolean init) {

    if (init) {
      initProcs(new SymboltableUnit<>());
      initTypes(new SymboltableUnit<>());
      initVars(new SymboltableUnit<>());
      outer = null;
    }

    else {
      procs = new SymboltableUnit<>();
      types = new SymboltableUnit<>();
      vars = new SymboltableUnit<>();
    }
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

  public int varSize() {
    return vars.size();
  }

  public Collection varsAsCollection() {
    return vars.asCollection();
  }

  public LinkedList<symboltable.Type> varsTypes() {
    return vars      
      .stream()
      .map(x -> x.getType())
      .collect(Collectors.toCollection(LinkedList::new));
  }

  private void initProcs(SymboltableUnit<Procedure> procs) {
    this.procs = procs;

    procs.add("readint",
	      new Procedure("readint",
			    new Symboltable(false),
			    Type.intType));      

    procs.add("readfloat",
	      new Procedure("readfloat",
			    new Symboltable(false),
			    Type.floatType));

    procs.add("readchar",
	      new Procedure("readchar",
			    new Symboltable(false),
			    Type.intType));

    procs.add("readstring",
	      new Procedure("readline",
			    new Symboltable(false),
			    Type.stringType));

    procs.add("readline",
	      new Procedure("readline",
			    new Symboltable(false),
			    Type.stringType));

    Symboltable printint = new Symboltable(false);
    printint.addVar("i", new Var("i", null, Type.intType));
    procs.add("printint",
	      new Procedure("printint",
			    printint,
			    Type.voidType));

    Symboltable printfloat = new Symboltable(false);
    printfloat.addVar("f", new Var("f", null, Type.floatType));
    procs.add("printfloat",
	      new Procedure("printfloat",
			    printfloat,
			    Type.voidType));

    Symboltable printstr = new Symboltable(false);
    printstr.addVar("s", new Var("s", null, Type.stringType));
    procs.add("printstr",
	      new Procedure("printstr",
			    printstr,
			    Type.voidType));

    Symboltable printline = new Symboltable(false);
    printline.addVar("s", new Var("s", null, Type.stringType));
    procs.add("printline",
	      new Procedure("printline",
			    printline,
			    Type.voidType));

    
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
