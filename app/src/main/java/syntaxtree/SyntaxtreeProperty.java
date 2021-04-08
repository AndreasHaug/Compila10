package syntaxtree;

public interface SyntaxtreeProperty {

  public default String indent(int indent) {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (int a = 0; a < indent; a++)
      sb.append("  ");
    return sb.toString();
  }

  public String printSyntaxtree(int indent);
  
}
