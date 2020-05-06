import java.io.IOException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

public class csvReader {
   public static HashMap<Integer, HashMap<String, String>> getTableFromFile(String filename) {
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromFileName(filename);
         // create a lexer that feeds off of input CharStream:
         csvLexer lexer = new csvLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         csvParser parser = new csvParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at main rule:
         ParseTree tree = parser.main();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            MyCSVVisitor visitor0 = new MyCSVVisitor();
            return (HashMap<Integer, HashMap<String,String>>)visitor0.visit(tree);
         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
      return null;
   }
}
