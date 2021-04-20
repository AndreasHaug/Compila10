package error;

public class NoMainProcedure extends Error {

  public NoMainProcedure() {
    super("Error: no main procedure in program");
  }
}
