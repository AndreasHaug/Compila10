package error;

public class WrongNumberOfArguments extends Error {

  public WrongNumberOfArguments(int params, int args) {
    super("In procedure call numbers of arguments expected to be " +
	  params +
	  " but the actual number is " +
	  args);
  }
}
