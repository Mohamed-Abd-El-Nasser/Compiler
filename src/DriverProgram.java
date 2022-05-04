import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * This is the detailed description for the <b>DriverProgram</b> class,
 * this is the main class used to instantiate from the Listener classes;
 * <b>MainListener</b> and <b>HTMLListener</b> and uses some driver functions
 * to perform the required tasks of generating injected java code, running the
 * generated intermediate java code, and generating html output to color entered
 * and not entered blocks.
 */

public class DriverProgram {
      /**
     * The <b>main</b> function is used as a driver function for the whole program, it reads the input java file,
     * generates the lexer, generates tokens, builds parser for these tokens, and generates a parse tree, then it
     * calls <b>generateIntermediateCode</b> to generate java code, <b>runIntermediateCode</b> to run the generated code, and
     * <b>generateHtmlOutput</b> to generate output html file indicating which blocks were entered and which were not.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        int testNumber = 1;

        CharStream input = CharStreams.fromFileName("Test/Test" + testNumber + ".java");

        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);

        ParseTree tree = parser.compilationUnit();

        generateIntermediateCode(testNumber,tokens,tree);

        String javaLocation = "/home/mmohie/.jdks/openjdk-18/bin/java";
         runIntermediateCode(testNumber,javaLocation);

         generateHtmlOutput(testNumber,tokens,tree);

    }

    /**
     * The <b>generateIntermediateCode</b> function is used to instantiate an object from MainListener class that contains
     * <b>TokenStreamRewriter</b> object with the injected java code, this function mainly generates an intermediate
     * java file injected with a specific java statements.
     * @param testNumber
     * @param tokens
     * @param tree
     * @throws Exception
     */
    public static void generateIntermediateCode (int testNumber, CommonTokenStream tokens, ParseTree tree) throws Exception {
        MainListener extractor = new MainListener(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(extractor, tree);
        File outputFile = new File("Test/intermediate-code/genCodeTest" + testNumber + ".java");
        if (!outputFile.createNewFile()) {
            outputFile.delete() ;
            outputFile = new File("Test/intermediate-code/genCodeTest" + testNumber + ".java");
        }
        FileWriter myWriter = new FileWriter("Test/intermediate-code/genCodeTest" + testNumber +".java");

//         StringBuffer content = new StringBuffer(extractor.rewriter.getText().replace("public class Test" + testNumber + " {\n" +
//                 "    public static void main(String[] args) throws Exception{"  , "import java.io.FileWriter;\n" +
//                 "public class genCodeTest" + testNumber + "{\n" +
//                 "    public static void main(String[] args) throws Exception{\n" +
//                 "        FileWriter fileWriter = new FileWriter(\"Test/executionOutput.txt\");"));
        
        StringBuffer content = new StringBuffer(extractor.rewriter.getText());
        
        content.replace(14,97,"import java.io.FileWriter;\n" +
                "public class genCodeTest" + testNumber + "{\n" +
                "    public static void main(String[] args) throws Exception{\n" +
                "        FileWriter fileWriter = new FileWriter(\"Test/executionOutput.txt\");");

        int strLength = content.length();

        content.replace(strLength-4,strLength-4,"\tfileWriter.close();\n\t");

        myWriter.write(String.valueOf(content));

        myWriter.close();
    }

    /**
     * The <b>runIntermediateCode</b> function is mainly used to run the generated intermediate code to show
     * which blocks are entered, print them in console, and write these blocks numbers in a text file.
     * @param testNumber
     * @param javaProgramLocation
     * @throws Exception
     */
    public static void runIntermediateCode (int testNumber,String javaProgramLocation) throws Exception {
        String command[] = {javaProgramLocation,"Test/intermediate-code/genCodeTest" + testNumber +".java"};

        ProcessBuilder processBuilder = new ProcessBuilder(command);

        Process process = processBuilder.start();
        int procExitValue = process.waitFor();

        // Check if any errors or compilation errors encounter then print on Console.
        if( process.getErrorStream().read() != -1 ){
            printGeneratedCodeOutput("Compilation Errors",process.getErrorStream());
        }

        // Check if java process execute successfully or Not, 0 - successful

        if( procExitValue == 0 ) {
            process = new ProcessBuilder(command).start();
            // Check if RuntimeException or Errors encounter during execution then print errors on console Otherwise print Output
            if (process.getErrorStream().read() != -1) {
                printGeneratedCodeOutput("Errors ", process.getErrorStream());
            } else {
                printGeneratedCodeOutput("Output ", process.getInputStream());
            }
        }
    }

    /**
     * The <b>printGeneratedCodeOutput</b> is considered a helper function used by the <b>runIntermediateCode</b>
     * function to print out the result of running the generated intermediate code using java process builder.
     * @param status
     * @param input
     * @throws IOException
     */
    public static void printGeneratedCodeOutput(String status,InputStream input) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        System.out.println("*********************** " + status + " ***********************");
        String line = null;
        while((line = in.readLine()) != null ){
            System.out.println(line);
        }
        in.close();
    }
    /**
     * The <b>generateHtmlOutput</b> function is used to instantiate an object from HTMLListener class that contains
     * <b>TokenStreamRewriter</b> object with the injected html code, this function mainly generates an html file
     * injected with an html code with coloring to show which block are entered and which are not.
     * @param testNumber
     * @param tokens
     * @param tree
     * @throws Exception
     */
    public static void generateHtmlOutput (int testNumber, CommonTokenStream tokens, ParseTree tree) throws Exception {
        HTMLListener htmlExtractor = new HTMLListener(tokens, readOutPutTxtFile());
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(htmlExtractor, tree);
        File outputHTMLFile = new File("Test/html-output/outputHtmlTest" + testNumber + ".html");
        if (!outputHTMLFile.createNewFile()) {
            outputHTMLFile.delete() ;
            outputHTMLFile = new File("Test/html-output/outputHtmlTest" + testNumber + ".html");
        }
        FileWriter myWriter2 = new FileWriter("Test/html-output/outputHtmlTest" + testNumber + ".html");
        myWriter2.write(htmlExtractor.rewriter.getText());
        myWriter2.close();
    }

    /**
     * The <b>readOutPutTxtFile</b> is a helper function used by <b>generateHtmlOutput</b> function to read the output text
     * file generated from running the intermediate code to know which block are entered and which are not.
     * @return ArrayList<Integer>
     */
    static ArrayList<Integer> readOutPutTxtFile() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            File myObj = new File("Test/executionOutput.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                list.add(Integer.valueOf(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return list;
    }

}
