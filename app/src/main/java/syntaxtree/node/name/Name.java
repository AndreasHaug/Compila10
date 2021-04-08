package node;

public class Name implements syntaxtree.SyntaxtreeProperty {

  private String n;

  public Name(String n) {
    this.n = n;
  }

  public String getName() {
    return n;
  }

  public String printSyntaxtree(int indent) {
    return "NAME:" + n;
  }

  public String toString() {
    return " " + n + " ";
  }
}
