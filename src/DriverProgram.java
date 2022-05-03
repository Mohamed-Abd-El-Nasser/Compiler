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

public class DriverProgram {
    public static void main(String[] args) throws Exception {
        int testNumber = 3;

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
    private static void generateIntermediateCode (int testNumber, CommonTokenStream tokens, ParseTree tree) throws Exception {
        MyListenerClass extractor = new MyListenerClass(tokens);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(extractor, tree);
        File outputFile = new File("Test/intermediate-code/genCodeTest" + testNumber + ".java");
        if (!outputFile.createNewFile()) {
            outputFile.delete() ;
            outputFile = new File("Test/intermediate-code/genCodeTest" + testNumber + ".java");
        }
        FileWriter myWriter = new FileWriter("Test/intermediate-code/genCodeTest" + testNumber +".java");

        StringBuffer content = new StringBuffer(extractor.rewriter.getText().replace("public class Test" + testNumber + " {\n" +
                "    public static void main(String[] args) throws Exception{"  , "import java.io.FileWriter;\n" +
                "public class genCodeTest" + testNumber + "{\n" +
                "    public static void main(String[] args) throws Exception{\n" +
                "        FileWriter fileWriter = new FileWriter(\"Test/executionOutput.txt\");"));

        int strLength = content.length();

        content.replace(strLength-3,strLength-3,"\tfileWriter.close();\n\t");

        myWriter.write(String.valueOf(content));

        myWriter.close();
    }

    private static void runIntermediateCode (int testNumber,String javaLocation) throws Exception {
        String command[] = {javaLocation,"Test/intermediate-code/genCodeTest" + testNumber +".java"};

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
    private static void printGeneratedCodeOutput(String status,InputStream input) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        System.out.println("*********************** " + status + " ***********************");
        String line = null;
        while((line = in.readLine()) != null ){
            System.out.println(line);
        }
        in.close();
    }
    private static void generateHtmlOutput (int testNumber, CommonTokenStream tokens, ParseTree tree) throws Exception {
        HTMLListener htmlExtractor = new HTMLListener(tokens, readOutPutTxtFile(testNumber));
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

    static ArrayList<Integer> readOutPutTxtFile(int testNo) {
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