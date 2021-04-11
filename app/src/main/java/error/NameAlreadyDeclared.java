package error;

public class NameAlreadyDeclared extends Error {

    public NameAlreadyDeclared(String name) {
	super(name + " is already declared");
    }
}
