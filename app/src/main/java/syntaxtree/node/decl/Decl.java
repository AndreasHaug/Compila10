package node;

import symboltable.Symboltable;
import syntaxtree.SyntaxtreeProperty;

public abstract class Decl implements SyntaxtreeProperty {
  protected Symboltable table;
}
