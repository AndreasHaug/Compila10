package compila;

import parser.*;
import syntaxtree.*;
import node.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import symboltable.Symboltable;

public class App {

  public static void main(String[] args) throws FileNotFoundException,
						IOException {    
    App app = new App();    
    app.doRunCompiler(args);
  }

    public void doRunCompiler(String args[]) {

	Symboltable st = new Symboltable();
	
    FileReader reader = null; 
    BufferedWriter bw = null;
    Program p = null;
   
    try {
      try {
	reader = new FileReader(args[0]);	
      }
      catch (FileNotFoundException f) {
	System.out.println("File " + args[0] + " not found");
	System.exit(0);
      }
      try {
	bw = new BufferedWriter(new FileWriter(args[1]));      	      	
      }
      catch (IOException i) {}
    }
    catch (ArrayIndexOutOfBoundsException a) {
      System.out.println("Missing input and/or output file");
      System.out.println("Terminating.");
      System.exit(0);
    }



    parser par = new parser(new Lexer(reader));
    try {
      p = (Program) par.parse().value;     
      Syntaxtree ast = new Syntaxtree(p);
      p.semanticAnalyze(new Symboltable());
      String astPrint = ast.printSyntaxtree(0);

      bw.flush();
      bw.write(astPrint);
      bw.close();
      // return astPrint;
    }
    catch (Exception e) {
      System.out.println("Syntax error");
      e.printStackTrace();
      System.exit(0);
    }

    
    //Rest of the compiler functionality to be implemented
    // return null;
  }


  public String doRunParser(String args[]) {
    FileReader reader = null; 
    BufferedWriter bw = null;
    Program p = null;
   
    try {
      try {
	reader = new FileReader(args[0]);	
      }
      catch (FileNotFoundException f) {
	System.out.println("File " + args[0] + " not found");
	System.exit(0);
      }
      try {
	bw = new BufferedWriter(new FileWriter(args[1]));      	      	
      }
      catch (IOException i) {}
    }
    catch (ArrayIndexOutOfBoundsException a) {
      System.out.println("Missing input and/or output file");
      System.out.println("Terminating.");
      System.exit(0);
    }
    
    parser par = new parser(new Lexer(reader));

    try {
      p = (Program) par.parse().value;     
      Syntaxtree ast = new Syntaxtree(p);
      String astPrint = ast.printSyntaxtree(0);

      bw.flush();
      bw.write(astPrint);
      bw.close();
      return astPrint;
    }
    catch (Exception e) {
      System.out.println("Syntax error");
      e.printStackTrace();
      System.exit(0);
    }

    return null;
  }
  
}
