package compila;

import parser.*;
import syntaxtree.*;
import node.*;
import error.*;

import java.io.File;
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

    if (args.length == 0 || args.length > 2) {
      System.out.println("Compila10, a small language running on JVM.");
      System.out.println("Usage: compila [option] <filename>\n");
      System.out.println("-c    --compile\t\tCompile cmp source file");
      System.out.println("-r    --run\t\tExecute bytecode file");
      System.out.println("Without option the program takes a compila source file, compiles and executes the bytecode.");
      return;
    }

    //setting different modes based on cli flags
    boolean compileAndRun = args.length == 1;
    boolean compile = args[0].equals("-c") || args[0].equals("--compile");
    boolean run = args[0].equals("-r") || args[0].equals("--run");

    if (!compileAndRun && !compile & !run) {
      System.out.println("Error: argument " + args[0] + " is invalid");
      System.exit(1);
    }
        
    String filename = "";
    if (compileAndRun) {
      filename = args[0];
      if (!filename.endsWith(".cmp")) {
	System.out.println("Error: Compila source files must end with \".cmp\"");
	System.exit(1);
      }
    }
    else if (compile) {
      filename = args[1];
      if (!filename.endsWith(".cmp")) {
	System.out.println("Error: Compila source files must end with \".cmp\"");
	System.exit(1);
      }
    }
    else {
      filename = args[1];
      if (!filename.endsWith(".bin")) {
	System.out.println("Error: Compila bytecode files must end with \".bin\"");
	System.exit(1);
      }
    }

    Symboltable st = new Symboltable(true);
	
    FileReader reader = null; 
    BufferedWriter bw = null;
    Program p = null;
   
    // try {
    try {
      reader = new FileReader(filename);	
    }
    catch (FileNotFoundException f) {
      System.out.println("File " + args[0] + " not found");
      System.exit(0);
    }

    //setting the filename of the bytecode file
    String binFilename = filename.split("\\.")[0] + ".bin";

    //if have to compile
    if (!run) {
      parser par = new parser(new Lexer(reader));
      try {
	p = (Program) par.parse().value;     
	Syntaxtree ast = new Syntaxtree(p);
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

      //write the bytecode to file
      try {
	byte[] bytecode = codefile.getBytecode();	
	DataOutputStream stream = new DataOutputStream(new FileOutputStream(binFilename));
	stream.write(bytecode);
	stream.close();
      }
      catch (FileNotFoundException fnf) {/* some error handling would be nice*/}
      catch (IOException ioe) {/* some error handling would be nice*/}

    }

    //running the virtual machine if supposed to
    if (compileAndRun || run) {         
      try{
	runtime.VirtualMachine vm = new runtime.VirtualMachine(binFilename);
	vm.run();
	if (compileAndRun) {
	  File binary = new File(binFilename);
	  binary.delete();	  
	}
      }
      catch (Exception e) {}
    }
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
