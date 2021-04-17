package symboltable;

public class RefType extends Type {

  private symboltable.Type referenced;

  public RefType(symboltable.Type referenced) {
    this.referenced = referenced;
  }

  public String toString() {
    return "ref(" + referenced.toString() + ")";
  }
}
