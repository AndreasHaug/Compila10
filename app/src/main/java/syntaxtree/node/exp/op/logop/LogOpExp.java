package node;

public abstract class LogOpExp extends OpExp {

  public LogOpExp(Exp l, Exp r) {
    super(l, r);
  }

  @Override
  public String printSyntaxtree(int indent) {
    return indent(indent) + super.printSyntaxtree(indent+1);
  }

  @Override
  public symboltable.Type semanticAnalyze() {
    return symboltable.Type.boolType;
  }
}
