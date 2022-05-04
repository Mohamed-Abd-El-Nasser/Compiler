import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

/**
 * This is the detailed description for <b>MainListener</b> class that extends <b>JavaParserBaseListener</b>, this class
 * is created in order to inject java statements to show which blocks will be executed and  which will not be executed
 * for a specific java file, each injected java code fragment includes a print statement for the block and writing block
 * number in an external text file.
 */
public class MainListener extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;
    int blocksCount = 1;

    /**
     * The <b>MainListener</b> class constructor is used to initialize the rewriter object with the token stream.
     * @param tokens
     */
    public MainListener(TokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
    }
    /**
     * The <b>enterIfStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when entering an if block, the function mainly inserts left brace if the block does not have one, a print
     * statement with the block number, and another statement to write the block number in a text file.
     * @param ctx
     */
    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx){
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"%d\\n\"", blocksCount);
        if(ctx.getChild(2).getText().charAt(0) =='{') {
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertAfter(ctx.ifBody.getStart(), injectedCode);
        }else{
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertAfter(ctx.ifExp.getStop(), '{');
            rewriter.insertBefore(ctx.ifBody.getStart(), injectedCode);
        }
        blocksCount++;
        super.enterIfStatement(ctx);
    }
    /**
     * The <b>exitIfStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when exiting an if block, the function mainly inserts right brace if the block does not have one.
     * @param ctx
     */
    @Override
    public void exitIfStatement(JavaParser.IfStatementContext ctx) {
        if(ctx.getChild(2).getText().charAt(0) !='{') {
            rewriter.insertAfter(ctx.ifBody.getStop(), "\n\t\t}");
        }
        super.exitIfStatement(ctx);
    }
    /**
     * The <b>enterElseStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when entering an else block, the function mainly inserts left brace if the block does not have one, a print
     * statement with the block number, and another statement to write the block number in a text file.
     * @param ctx
     */
    @Override
    public void enterElseStatement(JavaParser.ElseStatementContext ctx) {
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"%d\\n\"", blocksCount);

        if(ctx.getChildCount()>0){
            int count = ctx.getChildCount();
            if(!ctx.elseBody.getStart().getText().equals("if")){
                if(ctx.getChild(1).getText().charAt(0) =='{') {
                    String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
                    rewriter.insertAfter(ctx.elseBody.getStart(), injectedCode);
                }
                else{
                    String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
                    rewriter.insertAfter(ctx.ELSE().getSymbol(), '{');
                    rewriter.insertBefore(ctx.elseBody.getStart(), injectedCode);
                }
            }
            blocksCount++;
        }
        super.enterElseStatement(ctx);
    }
    /**
     * The <b>exitElseStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when exiting an else block, the function mainly inserts right brace if the block does not have one.
     * @param ctx
     */
    @Override
    public void exitElseStatement(JavaParser.ElseStatementContext ctx) {
        if (!ctx.elseBody.getStart().getText().equals("if")) {
            if (ctx.getChild(1).getText().charAt(0) !='{') {
                rewriter.insertAfter(ctx.elseBody.getStop(), "\n\t\t}");
            }
            super.exitElseStatement(ctx);
        }
    }
    /**
     * The <b>enterForStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when entering a for block, the function mainly inserts left brace if the block does not have one, a print
     * statement with the block number, and another statement to write the block number in a text file.
     * @param ctx
     */
    @Override
    public void enterForStatement(JavaParser.ForStatementContext ctx) {
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"%d\\n\"", blocksCount);
        if(ctx.getChild(4).getText().charAt(0) =='{') {
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertAfter(ctx.forBody.getStart(), injectedCode);
            rewriter.insertBefore(ctx.forBody.getStop(),"\n\t\tbreak;");
        }
        else{
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";

            rewriter.insertAfter(ctx.endBracket, '{');
            rewriter.insertBefore(ctx.forBody.getStart(), injectedCode);
        }
        blocksCount++;
        super.enterForStatement(ctx);
    }
    /**
     * The <b>exitForStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when exiting a for block, the function mainly inserts right brace if the block does not have one.
     * @param ctx
     */
    @Override
    public void exitForStatement(JavaParser.ForStatementContext ctx) {

        if(ctx.getChild(4).getText().charAt(0) !='{') {
            rewriter.insertAfter(ctx.forBody.getStop(), "\n\t\tbreak;");
            rewriter.insertAfter(ctx.forBody.getStop(), "\n\t\t}");
        }

        super.exitForStatement(ctx);
    }
    /**
     * The <b>enterWhileStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when entering a while block, the function mainly inserts left brace if the block does not have one, a print
     * statement with the block number, and another statement to write the block number in a text file.
     * @param ctx
     */
    @Override
    public void enterWhileStatement(JavaParser.WhileStatementContext ctx) {

        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"%d\\n\"", blocksCount);

        if(ctx.getChild(2).getText().charAt(0) =='{') {
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertBefore(ctx.whileBody.getStop(),"\n\t\tbreak;");
            rewriter.insertAfter(ctx.whileBody.getStart(), injectedCode);

        }else{
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
            rewriter.insertAfter(ctx.whileExp.getStop(), '{');
            rewriter.insertBefore(ctx.whileBody.getStart(), injectedCode);
        }
        blocksCount++;

        super.enterWhileStatement(ctx);
    }
    /**
     * The <b>exitWhileStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when exiting a while block, the function mainly inserts right brace if the block does not have one.
     * @param ctx
     */
    @Override
    public void exitWhileStatement(JavaParser.WhileStatementContext ctx) {
        if(ctx.getChild(2).getText().charAt(0) !='{') {
            rewriter.insertAfter(ctx.whileBody.getStop(), "\n\t\tbreak;");
            rewriter.insertAfter(ctx.whileBody.getStop(), "\n\t\t}");
        }
        blocksCount++;
        super.exitWhileStatement(ctx);
    }
    /**
     * The <b>enterSwitchLabel</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when entering a switch label block, the function mainly inserts a print statement with the block number,
     * and another statement to write the block number in a text file.
     * @param ctx
     */
    @Override
    public void enterSwitchLabel(JavaParser.SwitchLabelContext ctx) {
        int lineNumber = ctx.start.getLine();

        String injectedMessage = String.format("\"%d\\n\"", blocksCount);
        blocksCount++;
        String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");" + "\n\t\t\tfileWriter.append(" + injectedMessage + ");\n";
        rewriter.insertAfter(ctx.COLON().getSymbol(), injectedCode);
        super.enterSwitchLabel(ctx);
    }
}
