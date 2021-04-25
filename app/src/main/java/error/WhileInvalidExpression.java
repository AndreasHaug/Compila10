package error;

public class WhileInvalidExpression extends Error {

  public WhileInvalidExpression() {
    super("Error: expression in while-statement must be bool");
  }
}
