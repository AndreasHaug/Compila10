package node;

public class NotAssignedVarDecl extends VarDecl {

  Type type;
  
  public NotAssignedVarDecl(Name name, Type type) {
    super(name);
    this.type = type;
    this.exp = null;
  }

  public String printSyntaxtree(int indent) {
    return (super.printSyntaxtree(indent) +      
	    type.printSyntaxtree(indent)) + ")";
  }
}
