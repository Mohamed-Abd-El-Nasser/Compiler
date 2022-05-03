import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

import java.util.ArrayList;

public class HTMLListener extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;
    int blocksCount = 1;
    ArrayList<Integer> blocks;

    public HTMLListener(TokenStream tokens, ArrayList<Integer> blocks) {
        rewriter = new TokenStreamRewriter(tokens);
        rewriter.insertBefore(0, "<html> <style>.green {background-color: green} .red{background-color: red}</style><body class=green><pre>");
        this.blocks = blocks;
    }

    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + "'>";
        rewriter.insertAfter(ctx.ifExp.stop, injectedMessage);
        blocksCount++;
        super.enterIfStatement(ctx);
    }

    @Override
    public void exitIfStatement(JavaParser.IfStatementContext ctx) {
        rewriter.insertAfter(ctx.ifBody.getStop(), "</pre>");
        super.exitIfStatement(ctx);
    }

    @Override
    public void enterElseStatement(JavaParser.ElseStatementContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + "'>";

        rewriter.insertBefore(ctx.start, injectedMessage);
        blocksCount++;
        super.enterElseStatement(ctx);
    }

    @Override
    public void exitElseStatement(JavaParser.ElseStatementContext ctx) {
        rewriter.insertAfter(ctx.elseBody.getStop(), "</pre>");
        super.exitElseStatement(ctx);
    }

    @Override
    public void enterForStatement(JavaParser.ForStatementContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + "'>";
        rewriter.insertBefore(ctx.FOR().getSymbol(), injectedMessage);


        blocksCount++;

        super.enterForStatement(ctx);
    }

    @Override
    public void exitForStatement(JavaParser.ForStatementContext ctx) {

        rewriter.insertAfter(ctx.forBody.getStop(), "</pre>");

        super.exitForStatement(ctx);
    }

    @Override
    public void enterWhileStatement(JavaParser.WhileStatementContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + "'>";
        rewriter.insertBefore(ctx.start, injectedMessage);
        blocksCount++;
        super.enterWhileStatement(ctx);
    }

    @Override
    public void exitWhileStatement(JavaParser.WhileStatementContext ctx) {
        rewriter.insertAfter(ctx.stop, "</pre>");
        super.exitWhileStatement(ctx);
    }

    @Override
    public void enterSwitchLabel(JavaParser.SwitchLabelContext ctx) {
        String color = this.blocks.contains(blocksCount) ? "green" : "red";
        String injectedMessage = "<pre class='" + color + "' id='" + blocksCount + "'>";
        rewriter.insertBefore(ctx.start, injectedMessage);
        blocksCount++;
        super.enterSwitchLabel(ctx);
    }


    @Override
    public void exitSwitchBlockStatementGroup(JavaParser.SwitchBlockStatementGroupContext ctx) {
        rewriter.insertAfter(ctx.stop, "</pre>");
        super.exitSwitchBlockStatementGroup(ctx);
    }
}
