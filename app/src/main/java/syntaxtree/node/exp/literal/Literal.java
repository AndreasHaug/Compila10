package node;

public abstract class Literal extends Exp implements syntaxtree.SyntaxtreeProperty {

  public abstract Object getLiteralValue();
}
