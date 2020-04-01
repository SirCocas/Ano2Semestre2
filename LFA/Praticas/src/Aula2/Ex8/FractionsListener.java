// Generated from Fractions.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FractionsParser}.
 */
public interface FractionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FractionsParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(FractionsParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionsParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(FractionsParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PrintFraction}
	 * labeled alternative in {@link FractionsParser#operations}.
	 * @param ctx the parse tree
	 */
	void enterPrintFraction(FractionsParser.PrintFractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PrintFraction}
	 * labeled alternative in {@link FractionsParser#operations}.
	 * @param ctx the parse tree
	 */
	void exitPrintFraction(FractionsParser.PrintFractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Attribution}
	 * labeled alternative in {@link FractionsParser#operations}.
	 * @param ctx the parse tree
	 */
	void enterAttribution(FractionsParser.AttributionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Attribution}
	 * labeled alternative in {@link FractionsParser#operations}.
	 * @param ctx the parse tree
	 */
	void exitAttribution(FractionsParser.AttributionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Div}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterDiv(FractionsParser.DivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitDiv(FractionsParser.DivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSub(FractionsParser.SubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSub(FractionsParser.SubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PureNumber}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPureNumber(FractionsParser.PureNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PureNumber}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPureNumber(FractionsParser.PureNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterMult(FractionsParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitMult(FractionsParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code readString}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReadString(FractionsParser.ReadStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code readString}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReadString(FractionsParser.ReadStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isFraction}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIsFraction(FractionsParser.IsFractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isFraction}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIsFraction(FractionsParser.IsFractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code isVariable}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIsVariable(FractionsParser.IsVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code isVariable}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIsVariable(FractionsParser.IsVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterSum(FractionsParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitSum(FractionsParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code power}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPower(FractionsParser.PowerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code power}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPower(FractionsParser.PowerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReduceFraction}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReduceFraction(FractionsParser.ReduceFractionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReduceFraction}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReduceFraction(FractionsParser.ReduceFractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterParenthesis(FractionsParser.ParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitParenthesis(FractionsParser.ParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link FractionsParser#fraction}.
	 * @param ctx the parse tree
	 */
	void enterFraction(FractionsParser.FractionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FractionsParser#fraction}.
	 * @param ctx the parse tree
	 */
	void exitFraction(FractionsParser.FractionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code negativeNumber}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 */
	void enterNegativeNumber(FractionsParser.NegativeNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code negativeNumber}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 */
	void exitNegativeNumber(FractionsParser.NegativeNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code positiveNumber}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 */
	void enterPositiveNumber(FractionsParser.PositiveNumberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code positiveNumber}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 */
	void exitPositiveNumber(FractionsParser.PositiveNumberContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberIsLiteral}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 */
	void enterNumberIsLiteral(FractionsParser.NumberIsLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberIsLiteral}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 */
	void exitNumberIsLiteral(FractionsParser.NumberIsLiteralContext ctx);
}