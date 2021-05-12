package compila;

import parser.*;
import syntaxtree.*;
import node.*;
import error.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import bytecode.CodeProcedure;
import bytecode.instructions.PUSHINT;
import bytecode.instructions.RETURN;
import bytecode.instructions.STOREGLOBAL;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileOutputStream;

import symboltable.Symboltable;

public class App {

  public static void main(String[] args) throws FileNotFoundException,
                                                IOException {    
    App app = new App();    
    app.doRunCompiler(args);
  }

  public void doRunCompiler(String args[]) {

    Symboltable st = new Symboltable(true);
	
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
      // try {
      // bw = new BufferedWriter(new FileWriter(args[1]));      	      	
      // }
      // catch (IOException i) {}
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
      // String astPrint = ast.printSyntaxtree(0);

      // bw.flush();
      // bw.write(astPrint);
      // bw.close();
      p.semanticAnalyze(st);
    }
    catch (error.ScannerError se) {
      se.getMessage();
    }
    catch (Exception e) {
      System.out.println("Syntax error");
      e.printStackTrace();
      System.exit(0);
    }

    if (st.lookupProcedure("main") == null) {
      throw new NoMainProcedure();
    }
    
    //Rest of the compiler functionality to be implemented
    bytecode.CodeFile codefile = new bytecode.CodeFile();
    CodeProcedure readInt = new CodeProcedure("readint", bytecode.type.IntType.TYPE, codefile);
    codefile.addProcedure("readint");
    codefile.updateProcedure(readInt);
    
    CodeProcedure readFloat = new CodeProcedure("readfloat", bytecode.type.FloatType.TYPE, codefile);
    codefile.addProcedure("readfloat");
    codefile.updateProcedure(readFloat);
    
    CodeProcedure readChar = new CodeProcedure("readchar", bytecode.type.IntType.TYPE, codefile);
    codefile.addProcedure("readchar");
    codefile.updateProcedure(readChar);

    CodeProcedure readString = new CodeProcedure("readstring", bytecode.type.StringType.TYPE, codefile);
    codefile.addProcedure("readstring");
    codefile.updateProcedure(readString);

    CodeProcedure readLine = new CodeProcedure("readline", bytecode.type.StringType.TYPE, codefile);
    codefile.addProcedure("readline");
    codefile.updateProcedure(readLine);

    CodeProcedure printInt = new CodeProcedure("printint", bytecode.type.VoidType.TYPE, codefile);    
    printInt.addParameter("i", bytecode.type.IntType.TYPE);
    codefile.addProcedure("printint");
    codefile.updateProcedure(printInt);

    CodeProcedure printFloat = new CodeProcedure("printfloat", bytecode.type.VoidType.TYPE, codefile);
    printFloat.addParameter("f", bytecode.type.FloatType.TYPE);
    codefile.addProcedure("printfloat");
    codefile.updateProcedure(printFloat);

    CodeProcedure printStr = new CodeProcedure("printstr", bytecode.type.VoidType.TYPE, codefile);
    printFloat.addParameter("s", bytecode.type.StringType.TYPE);
    codefile.addProcedure("printstr");
    codefile.updateProcedure(printStr);

    CodeProcedure printLine = new CodeProcedure("printline", bytecode.type.VoidType.TYPE, codefile);
    printLine.addParameter("s", bytecode.type.StringType.TYPE);
    codefile.addProcedure("printline");
    codefile.updateProcedure(printLine);


    p.codegen(codefile);
    codefile.setMain("main");
      
    try {
      byte[] bytecode = codefile.getBytecode();
      DataOutputStream stream = new DataOutputStream(new FileOutputStream("testfile.bin"));
      stream.write(bytecode);
      stream.close();
    }
    catch (FileNotFoundException fnf) {/* some error handling would be nice*/}
    catch (IOException ioe) {/* some error handling would be nice*/}


    try{
      runtime.VirtualMachine vm = new runtime.VirtualMachine("testfile.bin");
      // vm.list();
      vm.run();
    }
    catch (Exception e) {}
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

  public void doRunSemanticChecker(String args[]) {

    Symboltable st = new Symboltable(true);
	
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
      p.semanticAnalyze(st);
    }
    catch (error.ScannerError se) {
      se.getMessage();
    }
    catch (Exception e) {
      System.out.println("Syntax error");
      e.printStackTrace();
      System.exit(0);
    }

    if (st.lookupProcedure("main") == null) {
      throw new NoMainProcedure();
    }
  }
}
