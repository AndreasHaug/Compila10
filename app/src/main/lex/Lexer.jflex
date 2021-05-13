package parser;

import java_cup.runtime.*;
import java.io.*;
import node.*;
// import node.*;

%%
%public
%class Lexer
%char
%line
%cup
%column

%eofval{
	return symbol(sym.EOF);
%eofval}
%eofclose


%{
 int linenumber() {
     return yyline+1;
}

private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
}

private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
}

private Symbol symbol(int type, Name n) {
    return new Symbol(type, n);
}

// private Symbol symbol(int type, FloatLiteral f) {
//     return new Symbol(type, f);
// }
// private Symbol symbol(int type, Intliteral i) {
//     return new Symbol(type, i);
// }

// private Symbol symbol(int type, Stringliteral s) {
    // return new Symbol(type, s);
// }

// private Symbol symbol(int type, Boolliteral b) {
//     return new Symbol(type, b);
// }


%}

//  //LineTerminator = "\r|\n|\r|\n"
 // LineTerminator = [\r\n]*
 LineTerminator = \r|\n|\r\n
 // WhiteSpace = {LineTerminator} | [ t\f] | [\t]
 WhiteSpace = {LineTerminator} | [ \t\f]
 Identifier = [:jletter:] [:jletterdigit:]*

%%




<YYINITIAL> {

  {WhiteSpace} {}
  {LineTerminator} {}

//  //[\(][\*](([^]|\n)*)[\*][\)] {System.out.println(linenumber() + ": Multiline comment starts.");}


//  //[\(][\*][^][\n\r]*[^][\*][\)] {System.out.println(linenumber() + ": Multiline comment starts.");}

 [\(][\*][^\*\)]*[\*][\)] {}

  // [\t] {}

 "//".* {}

// "\".*\""
\"([^\\\"]|\\.)*\"
 {
     Stringliteral s = new Stringliteral(yytext().substring(1, yytext().length()-1));
     return symbol(sym.STRINGLITERAL, s);
 }

 \"[^\"]*LineTerminator
 {
     System.out.println(linenumber() + ": Scanner error: unclosed string literal!");
     System.exit(0);
 }


// /*Floatliteral*/
 [0-9]*"."([0-9])+ {
    Floatliteral fl = new Floatliteral(Float.parseFloat(yytext()));
    return symbol(sym.FLOATLITERAL, fl);}

/*Intliteral*/
[0-9][0-9]*
{
    Intliteral il = new Intliteral(Integer.parseInt(yytext()));
    return symbol(sym.INTLITERAL, il);
}

  "&&" {return symbol(sym.AND);}
  "begin" {
  // System.out.println("begin");
  return symbol(sym.BEGIN);}
  "bool" {return symbol(sym.BOOL);}
  "deref" {return symbol(sym.DEREF);}
  "do" {return symbol(sym.DO);}
  "else" {return symbol(sym.ELSE);}
  "end" {
  //System.out.println("end");
  return symbol(sym.END);}
  "false"
  {
      Boolliteral b = new Boolliteral(false);      
      return symbol(sym.BOOLLITERAL, b);
  }
      
  "fi" {return symbol(sym.FI);}
  "float" {return symbol(sym.FLOAT);}
  "if" {return symbol(sym.IF);}
  "in" {return symbol(sym.IN);}
  "int" {return symbol(sym.INT);}
  "new" {return symbol(sym.NEW);}
  "not" {return symbol(sym.NOT);}
  "null" {return symbol(sym.NULL);}
  "od" {return symbol(sym.OD);}
  "||" {return symbol(sym.OR);}
  "procedure" {return symbol(sym.PROCEDURE);}
  "program" { //System.out.println("PROGRAM");
  return symbol(sym.PROGRAM);}
  "ref" {return symbol(sym.REF);}
  "return" {return symbol(sym.RETURN);}
  "string" {return symbol(sym.STRING);}
  "struct" {return symbol(sym.STRUCT);}
  "then" {return symbol(sym.THEN);}
  "true"
  {
      Boolliteral b = new Boolliteral(true);
      return symbol(sym.BOOLLITERAL, b);

  }
      
  "var" {return symbol(sym.VAR);}
  "while" {return symbol(sym.WHILE);}
  ";" {return symbol(sym.SEMICOLON);}
  "{" {return symbol(sym.CURLPARLEFT);}
  "}" {return symbol(sym.CURLPARRIGHT);}
  ":=" {return symbol(sym.ASSIGNMENT);}
  ":" {return symbol(sym.COLON);}
  "=" {return symbol(sym.EQUALS);}
  "(" {return symbol(sym.PARLEFT);}
  ")" {return symbol(sym.PARRIGHT);}
  "," {return symbol(sym.COMMA);}
  "." {return symbol(sym.DOT);}

  "/" {return symbol(sym.SLASH);}
  "<=" {return symbol(sym.LESSEQUAL);}
  "<" {return symbol(sym.LESS);}
  ">=" {return symbol(sym.GREATEREQUAL);}
  ">" {return symbol(sym.GREATER);}
  "<>" {return symbol(sym.LESSGREATER);}
  "\+" {return symbol(sym.PLUS);}
  "-" {return symbol(sym.MINUS);}
  "*" {return symbol(sym.ASTERISK);}
  "^" {return symbol(sym.CARET);}  
  
  [a-zA-Z]([a-zA-Z0-9|_])*([a-zA-Z0-9]*)
  //  [A-Za-z][\w$]*(\.[\w$]+)?(\[\d+])?
  {
      Name n = new Name(yytext());
      //System.out.println("name: " + yytext());
      return symbol(sym.NAME, n);
  }

  . {


throw new error.ScannerError(yytext(), yyline, yycolumn);
// System.out.println(linenumber() + "Scanner error: illegal character!"); System.exit(0);
}


  
  
  
  
  
}
