package Aula2;

import antlr4.HelloLexer;
import antlr4.HelloParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.*;

import java.io.IOException;

public class Ex1 {
    public static void main(String[] args) throws IOException {

        CharStream cs = CharStreams.fromFileName("test");
        HelloLexer lexer = new HelloLexer(cs);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        HelloParser parser = new HelloParser(tokens);

        ParseTree tree = parser.mainRule();


        ParseTreeWalker walker = new ParseTreeWalker();
        ParseTreeVisitor visitor = new ParseTreeVisitor() {
            @Override
            public Object visit(ParseTree parseTree) {
                System.out.println(parseTree.getChild(0).getChild(1));
                System.out.println(parseTree.getChild(1).getChild(1));
                return null;
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
