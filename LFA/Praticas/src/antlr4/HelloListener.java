// Generated from C:/Users/sofas/Documents/GitHub/Ano2Semestre2/LFA/Praticas/src/Aula2\Hello.g4 by ANTLR 4.8
package antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HelloParser}.
 */
public interface HelloListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HelloParser#mainRule}.
	 * @param ctx the parse tree
	 */
	void enterMainRule(HelloParser.MainRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#mainRule}.
	 * @param ctx the parse tree
	 */
	void exitMainRule(HelloParser.MainRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void enterGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#greetings}.
	 * @param ctx the parse tree
	 */
	void exitGreetings(HelloParser.GreetingsContext ctx);
	/**
	 * Enter a parse tree produced by {@link HelloParser#bye}.
	 * @param ctx the parse tree
	 */
	void enterBye(HelloParser.ByeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HelloParser#bye}.
	 * @param ctx the parse tree
	 */
	void exitBye(HelloParser.ByeContext ctx);
}