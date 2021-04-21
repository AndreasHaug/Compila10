package compila;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.io.IOException;

public class AppTest {

  App app;

  @Before
  public void setup() {
    app = new App();
  }

  public void doParserTest(int testfileNumber) throws IOException {

    String t = app
      .doRunParser(new String[] { "src/test/resources/parsing/test" + Integer.toString(testfileNumber) + ".cmp",
				 "src/test/resources/parsing/test" + Integer.toString(testfileNumber) + ".ast" });

    assertEquals(
		 (Files.lines(Paths.get("src/test/resources/parsing/test" + Integer.toString(testfileNumber) + ".ast")))
		 .collect(Collectors.joining()),
		 (Files.lines(Paths.get("src/test/resources/parsing/test" + Integer.toString(testfileNumber) + ".expected")))
		 .collect(Collectors.joining()));
  }

  public void parserFullProgramTest(String programname) {
    String t = app.doRunParser(new String[] { "src/test/resources/fullprograms/" + programname + ".cmp",
					     "src/test/resources/fullprograms/" + programname + ".ast" });
  }

  @Test
  public void test1() throws IOException {
    doParserTest(1);
  }

  @Test
  public void test2() throws IOException {
    doParserTest(2);
  }

  @Test
  public void test3() throws IOException {
    doParserTest(3);
  }

  @Test
  public void test4() throws IOException {
    doParserTest(4);
  }

  @Test
  public void test5() throws IOException {
    doParserTest(5);
  }

  @Test
  public void test6() throws IOException {
    doParserTest(6);
  }

  @Test
  public void test7() throws IOException {
    doParserTest(7);
  }

  @Test
  public void test8() throws IOException {
    doParserTest(8);
  }

  @Test
  public void test9() throws IOException {
    doParserTest(9);
  }

  @Test
  public void complexAdditionParserTest() {
    parserFullProgramTest("complexaddition");
  }

  @Test
  public void euclidParserTest() {
    parserFullProgramTest("euclid");
  }

  @Test
  public void plogParserTest() {
    parserFullProgramTest("plog");
  }

  @Test
  public void runmeParserTest() {
    parserFullProgramTest("runme");
  }

  @Test
  public void varDeclTest1() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/var_decl/var_decl1.cmp",
				    "src/test/resources/semanticanalysis/var_decl/var_decl1.ast" });
  }

  @Test(expected = error.NameAlreadyDeclared.class)
  public void varDeclTest2() {
    /**
     * Declaring a already declared variable should lead to an error
     */		
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/var_decl/var_decl2.cmp",
				    "src/test/resources/semanticanalysis/var_decl/var_decl2.ast" });
  }
		
  @Test
  public void varDeclTest3() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/var_decl/var_decl3.cmp",
				    "src/test/resources/semanticanalysis/var_decl/var_decl3.ast" });
  }
		
  @Test(expected = error.NoTypeExists.class)
  public void varDeclTest4() {
    /**
     * Declaring a variable with a nonexisting type should lead to an error
     */
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/var_decl/var_decl4.cmp",
				    "src/test/resources/semanticanalysis/var_decl/var_decl4.ast" });
  }

  @Test
  public void varDeclTest5() {
    /**
     * Legal variable declarations
     */
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/var_decl/var_decl5.cmp",
				    "src/test/resources/semanticanalysis/var_decl/var_decl5.ast" });
  }

  @Test(expected = error.MismatchedTypes.class)
  public void varDeclTest6() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/var_decl/var_decl6.cmp",
				    "src/test/resources/semanticanalysis/var_decl/var_decl6.ast" });
  }

  @Test(expected = error.NoTypeExists.class)
  public void varDeclTest7() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/var_decl/var_decl7.cmp",
				    "src/test/resources/semanticanalysis/var_decl/var_decl7.ast" });
  }

  @Test(expected = error.NameAlreadyDeclared.class)
  public void varDeclTest8() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/var_decl/var_decl8.cmp",
				    "src/test/resources/semanticanalysis/var_decl/var_decl8.ast" });
  }

  @Test
  public void recDeclTest1() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/rec_decl/recdecl1.cmp",
				    "src/test/resources/semanticanalysis/rec_decl/recdecl1.ast" });
  }

  @Test(expected = error.NoTypeExists.class)
  public void recDeclTest2() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/rec_decl/recdecl2.cmp",
				    "src/test/resources/semanticanalysis/rec_decl/recdecl2.ast" });
  }

  @Test(expected = error.NameAlreadyDeclared.class)
  public void recDeclTest3() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/rec_decl/recdecl3.cmp",
				    "src/test/resources/semanticanalysis/rec_decl/recdecl3.ast" });
  }

  @Test
  public void procDeclTest1() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/proc_decl/procdecl1.cmp",
				    "src/test/resources/semanticanalysis/proc_decl/procdecl1.ast" });
  }

  @Test(expected = error.NameAlreadyDeclared.class)
  public void procDeclTest2() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/proc_decl/procdecl2.cmp",
				    "src/test/resources/semanticanalysis/proc_decl/procdecl2.ast" });
  }

  @Test
  public void procDeclTest3() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/proc_decl/procdecl3.cmp",
				    "src/test/resources/semanticanalysis/proc_decl/procdecl3.ast" });
  }

  @Test
  public void procDeclTest4() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/proc_decl/procdecl4.cmp",
				    "src/test/resources/semanticanalysis/proc_decl/procdecl4.ast" });
  }

  @Test(expected = error.NameNotFound.class)
  public void procDeclTest5() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/proc_decl/procdecl5.cmp",
				    "src/test/resources/semanticanalysis/proc_decl/procdecl5.ast" });
  }

  @Test
  public void ifTest1() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/if/iftest1.cmp",
				    "src/test/resources/semanticanalysis/if/iftest1.ast" });
  }

  @Test(expected = error.IfInvalidExpression.class)
  public void ifTest2() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/if/iftest2.cmp",
				    "src/test/resources/semanticanalysis/if/iftest2.ast" });
  }

  
  @Test(expected = error.MismatchedTypes.class)
  public void procDeclTest6() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/proc_decl/procdecl6.cmp",
				    "src/test/resources/semanticanalysis/proc_decl/procdecl6.ast" });
  }

  
  @Test(expected = error.NameAlreadyDeclared.class)
  public void generalFail1() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/general1_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/general2_fail.ast" });
  }

  @Test(expected = error.NameAlreadyDeclared.class)
  public void generalFail2() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/general2_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/general2_fail.ast" });
  }

  @Test(expected = error.NameNotFound.class)
  public void generalFail3() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/general3_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/general3_fail.ast" });
  }


  /**
   * Checking missing main procedure
   */
  @Test(expected = error.NoMainProcedure.class)
  public void generalFail4() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/general4_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/general4_fail.ast" });
  }

  @Test(expected = error.MismatchedTypes.class)
  public void generalFail5() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/general5_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/general5_fail.ast" });
  }

  @Test(expected = error.InvalidReturnType.class)
  public void procedurefail2() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/procedure2_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/procedure2_fail.ast" });    
  }
  
  @Test(expected = error.InvalidReturnType.class)
  public void procedurefail3() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/procedure3_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/procedure3_fail.ast" });    
  }

  @Test(expected = error.WrongNumberOfArguments.class)
  public void procedurefail4() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/procedure4_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/procedure4_fail.ast" });    
  }

  @Test(expected = error.MismatchedTypes.class)
  public void procedurefail5() {
    app.doRunCompiler(new String[] { "src/test/resources/semanticanalysis/errors/procedure5_fail.cmp",
				    "src/test/resources/semanticanalysis/errors/procedure5_fail.ast" });    
  }

  @Test(expected = error.InvalidReturnType.class)
  public void procedureUnknownReturntypeFail() {
    app.doRunCompiler(new String[] {
	"src/test/resources/semanticanalysis/errors/procedure_unknown_returntype_fail.cmp",
	"src/test/resources/semanticanalysis/errors/procedure_unknown_returntype_fail.ast"
      });
  }

  @Test(expected = error.InvalidReturnType.class)
  public void returnContradictingExpressionFail() {
        app.doRunCompiler(new String[] {
	"src/test/resources/semanticanalysis/errors/return_contradicting_expression_fail.cmp",
	"src/test/resources/semanticanalysis/errors/return_contradicting_expression_fail.ast"
      });
  }

  @Test(expected = error.MismatchedTypes.class)
  public void type1Fail() {
        app.doRunCompiler(new String[] {
	"src/test/resources/semanticanalysis/errors/type1_fail.cmp",
	"src/test/resources/semanticanalysis/errors/type1_fail.ast"
      });
  }

  @Test(expected = error.IfInvalidExpression.class)
  public void type2Fail() {
        app.doRunCompiler(new String[] {
	"src/test/resources/semanticanalysis/errors/type2_fail.cmp",
	"src/test/resources/semanticanalysis/errors/type2_fail.ast"
      });
  }

  @Test(expected = error.MismatchedTypes.class)
  public void type3Fail() {
    app.doRunCompiler(new String[] {
	"src/test/resources/semanticanalysis/errors/type3_fail.cmp",
	"src/test/resources/semanticanalysis/errors/type3_fail.ast"
      });
  }

  // @Test
  // public void type4Fail() {
  //   app.doRunCompiler(new String[] {
  // 	"src/test/resources/semanticanalysis/errors/type4_fail.cmp",
  // 	"src/test/resources/semanticanalysis/errors/type4_fail.ast"
  //     });
  // }

  
}
