package error;

public class NoTypeExists extends Error {

  public NoTypeExists(String name) {
    super("Declaration of a type " + name + " which not exists");
  }
}
