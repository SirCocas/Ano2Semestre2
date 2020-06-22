import java.util.Scanner;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;

public class StrMain {
   public static void main(String[] args) {
	   for(String name : args){
		  try {
			 Scanner sc = new Scanner(new File(name));
			 String lineText = null;
			 int numLine = 1;
			 if (sc.hasNextLine())
				lineText = sc.nextLine();
			 StrParser parser = new StrParser(null);
			 // replace error listener:
			 //parser.removeErrorListeners(); // remove ConsoleErrorListener
			 //parser.addErrorListener(new ErrorHandlingListener());
			 MyVisitor visitor0 = new MyVisitor();
			 while(lineText != null) {
				// create a CharStream that reads from standard input:
				CharStream input = CharStreams.fromString(lineText + "\n");
				// create a lexer that feeds off of input CharStream:
				StrLexer lexer = new StrLexer(input);
				lexer.setLine(numLine);
				lexer.setCharPositionInLine(0);
				// create a buffer of tokens pulled from the lexer:
				CommonTokenStream tokens = new CommonTokenStream(lexer);
				// create a parser that feeds off the tokens buffer:
				parser.setInputStream(tokens);
				// begin parsing at main rule:
				ParseTree tree = parser.main();
				if (parser.getNumberOfSyntaxErrors() == 0) {
				   // print LISP-style tree:
				   // System.out.println(tree.toStringTree(parser));
				   visitor0.visit(tree);
				}
				if (sc.hasNextLine())
				   lineText = sc.nextLine();
				else
				   lineText = null;
				numLine++;
			 }
		  }
		  catch(Exception e) {
			 e.printStackTrace();
			 System.exit(1);
		  }
	   }
	}
}
