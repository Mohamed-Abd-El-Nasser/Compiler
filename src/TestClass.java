import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.io.File;
import java.io.File;  // Import the File class
import java.io.FileWriter;   // Import the FileWriter class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileInputStream;
import java.util.*;

public class TestClass{
    public static void main(String[] args) throws Exception {

        CharStream input = CharStreams.fromFileName("Test/Test3.java");

        JavaLexer lexer = new JavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        JavaParser parser = new JavaParser(tokens);

        ParseTree tree = parser.compilationUnit();
        ParseTreeWalker walker = new ParseTreeWalker();
        MyListenerClass extractor = new MyListenerClass(tokens);
        walker.walk(extractor, tree);

        // write the answer to file
        File outputFile = new File("Test/outputTest3.java");
        if (!outputFile.createNewFile()) {
            outputFile.delete() ;
            outputFile = new File("Test/outputTest3.java");
        }
        FileWriter myWriter = new FileWriter("Test/outputTest3.java");
        myWriter.write(extractor.rewriter.getText().replace("class Test3" , "class outputTest3"));
        myWriter.close();

    }
}