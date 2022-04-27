import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.FileWriter;

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
        myWriter.write(extractor.rewriter.getText().replace("class Test" + testNumber , "class genCodeTest" + testNumber));
        myWriter.close();

    }
}