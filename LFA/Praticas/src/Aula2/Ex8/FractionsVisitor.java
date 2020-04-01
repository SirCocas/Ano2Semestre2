// Generated from Fractions.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FractionsParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FractionsVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FractionsParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(FractionsParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PrintFraction}
	 * labeled alternative in {@link FractionsParser#operations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintFraction(FractionsParser.PrintFractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Attribution}
	 * labeled alternative in {@link FractionsParser#operations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribution(FractionsParser.AttributionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Div}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(FractionsParser.DivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sub}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSub(FractionsParser.SubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PureNumber}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPureNumber(FractionsParser.PureNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(FractionsParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code readString}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReadString(FractionsParser.ReadStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isFraction}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsFraction(FractionsParser.IsFractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code isVariable}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsVariable(FractionsParser.IsVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Sum}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(FractionsParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by the {@code power}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPower(FractionsParser.PowerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReduceFraction}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReduceFraction(FractionsParser.ReduceFractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesis}
	 * labeled alternative in {@link FractionsParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesis(FractionsParser.ParenthesisContext ctx);
	/**
	 * Visit a parse tree produced by {@link FractionsParser#fraction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFraction(FractionsParser.FractionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code negativeNumber}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegativeNumber(FractionsParser.NegativeNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code positiveNumber}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositiveNumber(FractionsParser.PositiveNumberContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberIsLiteral}
	 * labeled alternative in {@link FractionsParser#numbers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberIsLiteral(FractionsParser.NumberIsLiteralContext ctx);
}