package Aula2;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Ex2 {
    public static void main(String[] args) throws IOException {

        CharStream cs = CharStreams.fromFileName("test");
        Aula2.SuffixCalculatorLexer lexer = new Aula2.SuffixCalculatorLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        Aula2.SuffixCalculatorParser parser = new Aula2.SuffixCalculatorParser(tokens);

        ParseTree tree = parser.program();


        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTreeVisitor visitor = new ParseTreeVisitor() {
            @Override
            public Object visit(ParseTree parseTree) {
                System.out.println(parseTree.toStringTree());
                System.out.println(parseTree.getChild(0));
                return 0;
            }

            @Override
            public Object visitChildren(RuleNode ruleNode) {
                return null;
            }

            @Override
            public Object visitTerminal(TerminalNode terminalNode) {
                return null;
            }

            @Override
            public Object visitErrorNode(ErrorNode errorNode) {
                return null;
            }
        };
        visitor.visit(tree);
        //walker.walk((ParseTreeListener) listener, tree);
    }

}
