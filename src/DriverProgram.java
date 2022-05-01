import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DriverProgram {
    public static void main(String[] args) throws Exception {
        int testNumber = 4;
        CharStream input = CharStreams.fromFileName("Test/Test" + testNumber + ".java");

        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);

        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyListenerClass extractor = new MyListenerClass(tokens);
        walker.walk(extractor, tree);

        // write the answer to file
        File outputFile = new File("Test/genCodeTest" + testNumber + ".java");
        if (!outputFile.createNewFile()) {
            outputFile.delete() ;
            outputFile = new File("Test/genCodeTest" + testNumber + ".java");
        }
        FileWriter myWriter = new FileWriter("Test/genCodeTest" + testNumber +".java");

        StringBuffer content = new StringBuffer(extractor.rewriter.getText().replace("public class Test" + testNumber + " {\n" +
                "    public static void main(String[] args) throws Exception{"  , "import java.io.FileWriter;\n" +
                "public class genCodeTest" + testNumber + "{\n" +
                "    public static void main(String[] args) throws Exception{\n" +
                "        FileWriter fileWriter = new FileWriter(\"Test/executionOutput.txt\");"));

        int strLength = content.length();

        content.replace(strLength-3,strLength-3,"\tfileWriter.close();\n\t");

        myWriter.write(String.valueOf(content));

        myWriter.close();

        // Automatically run the generated code

        String command[] = {"/home/mmohie/.jdks/openjdk-18/bin/java","Test/genCodeTest" + testNumber +".java"};

        ProcessBuilder processBuilder = new ProcessBuilder(command);

        Process process = processBuilder.start();
        int procExitValue = process.waitFor();

        // Check if any errors or compilation errors encounter then print on Console.
        if( process.getErrorStream().read() != -1 ){
            print("Compilation Errors",process.getErrorStream());
        }

        // Check if java process execute successfully or Not, 0 - successful

        if( procExitValue == 0 ){
            process = new ProcessBuilder(command).start();
            // Check if RuntimeException or Errors encounter during execution then print errors on console Otherwise print Output
            if( process.getErrorStream().read() != -1 ){
                print("Errors ",process.getErrorStream());
            }
            else {
                print("Output ",process.getInputStream());
            }

        }
    }

    private static void print(String status,InputStream input) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(input));
        System.out.println("*********************** " + status + " ***********************");
        String line = null;
        while((line = in.readLine()) != null ){
            System.out.println(line);
        }
        in.close();
    }

}