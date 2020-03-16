// Generated from Calculator.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CalculatorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CalculatorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(CalculatorParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printValue}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintValue(CalculatorParser.PrintValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignValue}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignValue(CalculatorParser.AssignValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printLiteral}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintLiteral(CalculatorParser.PrintLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnReduction}
	 * labeled alternative in {@link CalculatorParser#literals}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnReduction(CalculatorParser.ReturnReductionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressPositive}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressPositive(CalculatorParser.ExpressPositiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressMath}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressMath(CalculatorParser.ExpressMathContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressFract}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressFract(CalculatorParser.ExpressFractContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressInt}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressInt(CalculatorParser.ExpressIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressPower}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressPower(CalculatorParser.ExpressPowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressParent}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressParent(CalculatorParser.ExpressParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressNegative}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressNegative(CalculatorParser.ExpressNegativeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressVar}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressVar(CalculatorParser.ExpressVarContext ctx);
	/**
	 * Visit a parse tree produced by {@link CalculatorParser#fraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraction(CalculatorParser.FractionContext ctx);
}