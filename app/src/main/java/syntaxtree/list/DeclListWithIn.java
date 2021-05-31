package list;

public class DeclListWithIn extends DeclList {

  private boolean isIn = false;
  
  public DeclListWithIn() {
    super();
  }
  
  public DeclListWithIn(DeclListWithIn l) {
    super(l);
  }

  public void setIn() {
    isIn = true;
  }

  @Override
  public String printSyntaxtreeList(int indent) {
    
    return super.printSyntaxtreeList(indent) +
      (isIn ?
       (list.size() > 0 ?
	indent(indent) + "in"
	: " in")
       : "");
  }
}
