import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.util.ArrayList;


/**
 * This is the detailed description for <b>HTMLListener</b> class that extends <b>JavaParserBaseListener</b>,
 * this class is created in order to inject html code with green color for blocks that will be executed and red
 * color for blocks that will not be executed for a specific java file.
 */

public class HTMLListener extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;
    int blocksCount = 1;
    ArrayList<Integer> blocks;
    /**
     * The <b>HTMLListener</b> class constructor is used to initialize the rewriter object with the token stream, initialize
     * blocks ArrayList with a list of executed blocks, and insert the html opening tag <html> at the beginning of the file.
     * @param tokens
     * @param blocks
     */
    public HTMLListener(TokenStream tokens, ArrayList<Integer> blocks) {
        rewriter = new TokenStreamRewriter(tokens);
        rewriter.insertBefore(0, "<html> <style>.green {background-color: #22C55E} .red{background-color: #EF4444}</style><body class=green><pre>");
        this.blocks = blocks;
    }
    /**
     * The <b>enterIfStatement</b> function overrides the actual function generated from the antlr recognizer, and it
     * is called when entering an if block, the function mainly inserts the opening tag <pre> before the body of the if
     * block, with green color if the block was executed, and red color for the block that was not executed.
     * @param ctx
     */
    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + "'>";
        rewriter.insertAfter(ctx.ifExp.stop, injectedMessage);
        blocksCount++;
        super.enterIfStatement(ctx);
    }
    /**
     * The <b>exitIfStatement</b> function overrides the actual function generated from the antlr recognizer, and it is
     * called when exiting an if block, the function mainly inserts the closing tag </pre> after the body of the if block.
     * @param ctx
     */
    @Override
    public void exitIfStatement(JavaParser.IfStatementContext ctx) {
        rewriter.insertAfter(ctx.ifBody.getStop(), "</pre>");
        super.exitIfStatement(ctx);
    }
    /**
     * The <b>enterElseStatement</b> function overrides the actual function generated from the antlr recognizer, and it
     * is called when entering an else block, the function mainly inserts the opening tag <pre> before the body of the
     * else block, with green color if the block was executed, and red color for the
     * block that was not executed.
     * @param ctx
     */
    @Override
    public void enterElseStatement(JavaParser.ElseStatementContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + "'>";

        rewriter.insertBefore(ctx.start, injectedMessage);
        blocksCount++;
        super.enterElseStatement(ctx);
    }
    /**
     * The <b>exitElseStatement</b> function overrides the actual function generated from the antlr recognizer, and it
     * is called when exiting an else block, the function mainly inserts the closing tag </pre> after the body of the else block.
     * @param ctx
     */
    @Override
    public void exitElseStatement(JavaParser.ElseStatementContext ctx) {
        rewriter.insertAfter(ctx.elseBody.getStop(), "</pre>");
        super.exitElseStatement(ctx);
    }
    /**
     * The <b>enterForStatement</b> function overrides the actual function generated from the antlr recognizer, and it
     * is called when entering a for block, the function mainly inserts the opening tag <pre> before the body of the for
     * block, with green color if the block was executed, and red color for the block that was not executed.
     * @param ctx
     */
    @Override
    public void enterForStatement(JavaParser.ForStatementContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + " '>";
        rewriter.insertBefore(ctx.FOR().getSymbol(), injectedMessage);


        blocksCount++;

        super.enterForStatement(ctx);
    }
    /**
     * The <b>exitForStatement</b> function overrides the actual function generated from the antlr recognizer, and it
     * is called when exiting a for block, the function mainly inserts the closing tag </pre> after the body of the for block.
     * @param ctx
     */
    @Override
    public void exitForStatement(JavaParser.ForStatementContext ctx) {

        rewriter.insertAfter(ctx.forBody.getStop(), "</pre>");

        super.exitForStatement(ctx);
    }
    /**
     * The <b>enterWhileStatement</b> function overrides the actual function generated from the antlr recognizer, and it
     * is called when entering a while block, the function mainly inserts the opening tag <pre> before the body of the
     * while block, with green color if the block was executed, and red color for the block that was not executed.
     * @param ctx
     */
    @Override
    public void enterWhileStatement(JavaParser.WhileStatementContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + " '>";
        rewriter.insertBefore(ctx.start, injectedMessage);
        blocksCount++;
        super.enterWhileStatement(ctx);
    }
    /**
     * The <b>exitWhileStatement</b> function overrides the actual function generated from the antlr recognizer, and it
     * is called when exiting a while block, the function mainly inserts the closing tag </pre> after the body of the while block.
     * @param ctx
     */
    @Override
    public void exitWhileStatement(JavaParser.WhileStatementContext ctx) {
        rewriter.insertAfter(ctx.stop, "</pre>");
        super.exitWhileStatement(ctx);
    }
    /**
     * The <b>enterSwitchLabel</b> function overrides the actual function generated from the antlr recognizer, and it
     * is called when entering a switch label block, the function mainly inserts the opening tag <pre> before the body
     * of the switch label block, with green color if the block was executed, and red color for the block that was not executed.
     * @param ctx
     */
    @Override
    public void enterSwitchLabel(JavaParser.SwitchLabelContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + " '>";
        rewriter.insertBefore(ctx.start, injectedMessage);
        blocksCount++;
        super.enterSwitchLabel(ctx);
    }
    /**
     * The <b>exitSwitchBlockStatementGroup</b> function overrides the actual function generated from the antlr recognizer,
     * and it is called when exiting a switch block statement, the function mainly inserts the closing tag </pre> after
     * the body of the switch block statement.
     * @param ctx
     */
    @Override
    public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {
        rewriter.insertAfter(ctx.stop, "</pre>");
        super.exitSwitchBlockStatementGroup(ctx);
    }
}