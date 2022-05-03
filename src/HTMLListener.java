import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.util.ArrayList;


/**
 * this is the detailed description for this class
 * the HTML listener class  is generate html code  in block executed and unexecuted  from an input java program.
 * green block is executed
 * red block is not executed
 *
 */

public class HTMLListener extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;
    int blocksCount = 1;
    ArrayList<Integer> blocks;
    /**
     * This class constructor is used to initialize the rewriter object and insert the html opening tag <html>
     * @param tokens,blocks
     */
    public HTMLListener(TokenStream tokens, ArrayList<Integer> blocks) {
        rewriter = new TokenStreamRewriter(tokens);
        rewriter.insertBefore(0, "<html> <style>.green {background-color: #22C55E} .red{background-color: #EF4444}</style><body class=green><pre>");
        this.blocks = blocks;
    }
    /**
     * this is function when enter if_block when Execution of condition if \n
     * coloring green block when enter if block \n
     * coloring  red block when no enter if block \n
     * @param ctx the parse tree
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
     * this is function when exit if_block insert </pre> html code \n
     *
     * @param ctx the parse tree
     */
    @Override
    public void exitIfStatement(JavaParser.IfStatementContext ctx) {
        rewriter.insertAfter(ctx.ifBody.getStop(), "</pre>");
        super.exitIfStatement(ctx);
    }
    /**
     * this is function when enter else statement_block when not Execution of condition if \n
     * coloring green block when enter else block \n
     * coloring  red block when no enter else block \n
     * @param ctx the parse tree
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
     * this is function when exit else_block insert </pre> html code \n
     *
     * @param ctx the parse tree
     */
    @Override
    public void exitElseStatement(JavaParser.ElseStatementContext ctx) {
        rewriter.insertAfter(ctx.elseBody.getStop(), "</pre>");
        super.exitElseStatement(ctx);
    }
    /**
     * this is function when enter for statement_block when not Execution of condition for \n
     * coloring green block when enter for block \n
     * coloring  red block when no enter for block \n
     * @param ctx the parse tree
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
     * this is function when exit for_block insert </pre> html code \n
     *
     * @param ctx the parse tree
     */
    @Override
    public void exitForStatement(JavaParser.ForStatementContext ctx) {

        rewriter.insertAfter(ctx.forBody.getStop(), "</pre>");

        super.exitForStatement(ctx);
    }
    /**
     * this is function when enter while statement_block when not Execution of condition while \n
     * coloring green block when enter while block \n
     * coloring  red block when no enter while block \n
     * @param ctx the parse tree
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
     * this is function when exit while_block insert </pre> html code \n
     * @param ctx the parse tree
     */
    @Override
    public void exitWhileStatement(JavaParser.WhileStatementContext ctx) {
        rewriter.insertAfter(ctx.stop, "</pre>");
        super.exitWhileStatement(ctx);
    }
    /**
     * this is function when enter switch statement_block when not Execution of condition while \n
     * coloring green block when switch case  block \n
     * coloring  red block when no switch case  block \n
     * @param ctx the parse tree
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
     * this is function when exit switch block closing "</pre>" html code \n
     * @param ctx the parse tree
     */
    @Override
    public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {
        rewriter.insertAfter(ctx.stop, "</pre>");
        super.exitSwitchBlockStatementGroup(ctx);
    }
}
