// Generated from C:/Users/sofas/Documents/GitHub/Ano2Semestre2/LFA/Praticas/src/Aula2\SuffixCalculator.g4 by ANTLR 4.8
package Aula2;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SuffixCalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SuffixCalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SuffixCalculatorParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SuffixCalculatorParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SuffixCalculatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(SuffixCalculatorParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SuffixCalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SuffixCalculatorParser.ExprContext ctx);
}