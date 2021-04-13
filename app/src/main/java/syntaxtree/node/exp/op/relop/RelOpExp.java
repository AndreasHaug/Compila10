package node;

public abstract class RelOpExp extends OpExp {

  public RelOpExp(Exp l, Exp r) {
    super(l, r);
  }

  @Override
  public symboltable.Type semanticAnalyze() {
    return symboltable.Type.boolType;
  } 
}
