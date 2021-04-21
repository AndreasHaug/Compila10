package error;

public class ScannerError extends Error {

  String yytext;
  int yyline;
  int yycolumn;
  
  public ScannerError(String yytext, int yyline, int yycolumn) {
    super();
    this.yytext = yytext;
    this.yyline = yyline;
    this.yycolumn = yycolumn;

    System.out.println("Scanner error: line " + yyline + ":");
    System.out.println("|" + yytext + "|");
    System.out.println();
    
  }


  // public String pointer() {
  //   StringBuilder b = new StringBuilder();
  //   for (int a = 0, a < yyline)


  //   return b.toString();
  // }
}
