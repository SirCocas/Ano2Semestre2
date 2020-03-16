// Generated from Calculator.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalculatorParser}.
 */
public interface CalculatorListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(CalculatorParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(CalculatorParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printValue}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintValue(CalculatorParser.PrintValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printValue}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintValue(CalculatorParser.PrintValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignValue}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAssignValue(CalculatorParser.AssignValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignValue}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAssignValue(CalculatorParser.AssignValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printLiteral}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintLiteral(CalculatorParser.PrintLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printLiteral}
	 * labeled alternative in {@link CalculatorParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintLiteral(CalculatorParser.PrintLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnReduction}
	 * labeled alternative in {@link CalculatorParser#literals}.
	 * @param ctx the parse tree
	 */
	void enterReturnReduction(CalculatorParser.ReturnReductionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnReduction}
	 * labeled alternative in {@link CalculatorParser#literals}.
	 * @param ctx the parse tree
	 */
	void exitReturnReduction(CalculatorParser.ReturnReductionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressPositive}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressPositive(CalculatorParser.ExpressPositiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressPositive}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressPositive(CalculatorParser.ExpressPositiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressMath}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressMath(CalculatorParser.ExpressMathContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressMath}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressMath(CalculatorParser.ExpressMathContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressFract}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressFract(CalculatorParser.ExpressFractContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressFract}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressFract(CalculatorParser.ExpressFractContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressInt}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressInt(CalculatorParser.ExpressIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressInt}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressInt(CalculatorParser.ExpressIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressPower}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressPower(CalculatorParser.ExpressPowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressPower}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressPower(CalculatorParser.ExpressPowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressParent}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressParent(CalculatorParser.ExpressParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressParent}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressParent(CalculatorParser.ExpressParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressNegative}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressNegative(CalculatorParser.ExpressNegativeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressNegative}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressNegative(CalculatorParser.ExpressNegativeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressVar}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpressVar(CalculatorParser.ExpressVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressVar}
	 * labeled alternative in {@link CalculatorParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpressVar(CalculatorParser.ExpressVarContext ctx);
	/**
	 * Enter a parse tree produced by {@link CalculatorParser#fraction}.
	 * @param ctx the parse tree
	 */
	void enterFraction(CalculatorParser.FractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalculatorParser#fraction}.
	 * @param ctx the parse tree
	 */
	void exitFraction(CalculatorParser.FractionContext ctx);
}