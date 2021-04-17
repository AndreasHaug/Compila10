package error;

public class InvalidReturnType extends Error {

  String msg;
  
  public InvalidReturnType(String msg) {
    this.msg = msg;
  }
}
