import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.TokenStreamRewriter;

public class MyListenerClass extends JavaParserBaseListener {
    TokenStreamRewriter rewriter;
    int ifBlockCount = 1;
    int elseBlockCount = 1;
    int forBlockCount = 1;

    public MyListenerClass(TokenStream tokens) {
        rewriter = new TokenStreamRewriter(tokens);
    }

    @Override
    public void enterIfStatement(JavaParser.IfStatementContext ctx){
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"IF Block number: %d at line number %d\"", ifBlockCount, lineNumber);
        if(ctx.getChild(2).getText().charAt(0) =='{') {
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");";
            rewriter.insertAfter(ctx.ifBody.getStart(), injectedCode);
        }else{
            String injectedCode = "System.out.println(" + injectedMessage + ");\n\t\t\t";
            rewriter.insertAfter(ctx.ifExp.getStop(), '{');
            rewriter.insertBefore(ctx.ifBody.getStart(), injectedCode);
        }
        ifBlockCount++;
        super.enterIfStatement(ctx);
    }

    @Override
    public void exitIfStatement(JavaParser.IfStatementContext ctx) {
        if(ctx.getChild(2).getText().charAt(0) !='{') {
            rewriter.insertAfter(ctx.ifBody.getStop(), "\n\t\t}");
        }
        super.exitIfStatement(ctx);
    }

    @Override
    public void enterElseStatement(JavaParser.ElseStatementContext ctx) {
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"ELSE Block number: %d at line number %d\"", elseBlockCount,lineNumber);

        if(ctx.getChildCount()>0){
            int count = ctx.getChildCount();
            if(!ctx.elseBody.getStart().getText().equals("if")){
                if(ctx.getChild(1).getText().charAt(0) =='{') {
                    String injectedCode = "\n\t\tSystem.out.println(" + injectedMessage + ");";
                    rewriter.insertAfter(ctx.elseBody.getStart(), injectedCode);
                }
                else{
                    String injectedCode = "System.out.println(" + injectedMessage + ");\n\t\t\t";
                    rewriter.insertAfter(ctx.ELSE().getSymbol(), '{');
                    rewriter.insertBefore(ctx.elseBody.getStart(), injectedCode);
                }
            }
            elseBlockCount++;
        }
        super.enterElseStatement(ctx);
    }

    @Override
    public void exitElseStatement(JavaParser.ElseStatementContext ctx) {
        if (!ctx.elseBody.getStart().getText().equals("if")) {
            if (ctx.getChild(1).getText().charAt(0) !='{') {
                rewriter.insertAfter(ctx.elseBody.getStop(), "\n\t\t}");
            }
            super.exitElseStatement(ctx);
        }
    }

    @Override
    public void enterForStatement(JavaParser.ForStatementContext ctx) {
        int lineNumber = ctx.start.getLine();
        String injectedMessage = String.format("\"For Block number: %d at line number %d\"", forBlockCount,lineNumber);
        if(ctx.getChild(4).getText().charAt(0) =='{') {
            String injectedCode = "\n\t\t\tSystem.out.println(" + injectedMessage + ");";
            rewriter.insertAfter(ctx.forBody.getStart(), injectedCode);

        }else{
            String injectedCode = "System.out.println(" + injectedMessage + ");\n\t\t\t";

            rewriter.insertAfter(ctx.endBracket, '{');
            rewriter.insertBefore(ctx.forBody.getStart(), injectedCode);
        }
        forBlockCount++;
 //       System.out.println(ctx.getChild(1));

        super.enterForStatement(ctx);
    }

    @Override
    public void exitForStatement(JavaParser.ForStatementContext ctx) {

        if(ctx.getChild(4).getText().charAt(0) !='{') {
            rewriter.insertAfter(ctx.forBody.getStop(), "\n\t\t}");
        }

        super.exitForStatement(ctx);
    }
}
