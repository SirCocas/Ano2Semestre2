// Generated from calc.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link calcParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface calcVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link calcParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(calcParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(calcParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#atrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtrib(calcParser.AtribContext ctx);
	/**
	 * Visit a parse tree produced by the {@code division}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivision(calcParser.DivisionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code singleGroup}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleGroup(calcParser.SingleGroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code interception}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterception(calcParser.InterceptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenthesisSequence}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesisSequence(calcParser.ParenthesisSequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(calcParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSum(calcParser.SumContext ctx);
	/**
	 * Visit a parse tree produced by {@link calcParser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(calcParser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequenceOfStrings}
	 * labeled alternative in {@link calcParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceOfStrings(calcParser.SequenceOfStringsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sequenceOfInts}
	 * labeled alternative in {@link calcParser#sequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSequenceOfInts(calcParser.SequenceOfIntsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntSeveralElements}
	 * labeled alternative in {@link calcParser#ints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntSeveralElements(calcParser.IntSeveralElementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntSingleElement}
	 * labeled alternative in {@link calcParser#ints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntSingleElement(calcParser.IntSingleElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringSeveralElements}
	 * labeled alternative in {@link calcParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringSeveralElements(calcParser.StringSeveralElementsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringSingleElement}
	 * labeled alternative in {@link calcParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringSingleElement(calcParser.StringSingleElementContext ctx);
}