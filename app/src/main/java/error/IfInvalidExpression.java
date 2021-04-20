package error;

public class IfInvalidExpression extends Error {

  public IfInvalidExpression() {
    super("Error: expression in if-statement must be bool");
  }
}
