// Generated from calc.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link calcParser}.
 */
public interface calcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link calcParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(calcParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(calcParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(calcParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(calcParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#atrib}.
	 * @param ctx the parse tree
	 */
	void enterAtrib(calcParser.AtribContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#atrib}.
	 * @param ctx the parse tree
	 */
	void exitAtrib(calcParser.AtribContext ctx);
	/**
	 * Enter a parse tree produced by the {@code division}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void enterDivision(calcParser.DivisionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code division}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void exitDivision(calcParser.DivisionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code singleGroup}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void enterSingleGroup(calcParser.SingleGroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code singleGroup}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void exitSingleGroup(calcParser.SingleGroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code interception}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void enterInterception(calcParser.InterceptionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code interception}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void exitInterception(calcParser.InterceptionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenthesisSequence}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void enterParenthesisSequence(calcParser.ParenthesisSequenceContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenthesisSequence}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void exitParenthesisSequence(calcParser.ParenthesisSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variable}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void enterVariable(calcParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variable}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void exitVariable(calcParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sum}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void enterSum(calcParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link calcParser#math}.
	 * @param ctx the parse tree
	 */
	void exitSum(calcParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by {@link calcParser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(calcParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link calcParser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(calcParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequenceOfStrings}
	 * labeled alternative in {@link calcParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequenceOfStrings(calcParser.SequenceOfStringsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequenceOfStrings}
	 * labeled alternative in {@link calcParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequenceOfStrings(calcParser.SequenceOfStringsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sequenceOfInts}
	 * labeled alternative in {@link calcParser#sequence}.
	 * @param ctx the parse tree
	 */
	void enterSequenceOfInts(calcParser.SequenceOfIntsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sequenceOfInts}
	 * labeled alternative in {@link calcParser#sequence}.
	 * @param ctx the parse tree
	 */
	void exitSequenceOfInts(calcParser.SequenceOfIntsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntSeveralElements}
	 * labeled alternative in {@link calcParser#ints}.
	 * @param ctx the parse tree
	 */
	void enterIntSeveralElements(calcParser.IntSeveralElementsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntSeveralElements}
	 * labeled alternative in {@link calcParser#ints}.
	 * @param ctx the parse tree
	 */
	void exitIntSeveralElements(calcParser.IntSeveralElementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntSingleElement}
	 * labeled alternative in {@link calcParser#ints}.
	 * @param ctx the parse tree
	 */
	void enterIntSingleElement(calcParser.IntSingleElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntSingleElement}
	 * labeled alternative in {@link calcParser#ints}.
	 * @param ctx the parse tree
	 */
	void exitIntSingleElement(calcParser.IntSingleElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringSeveralElements}
	 * labeled alternative in {@link calcParser#string}.
	 * @param ctx the parse tree
	 */
	void enterStringSeveralElements(calcParser.StringSeveralElementsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringSeveralElements}
	 * labeled alternative in {@link calcParser#string}.
	 * @param ctx the parse tree
	 */
	void exitStringSeveralElements(calcParser.StringSeveralElementsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringSingleElement}
	 * labeled alternative in {@link calcParser#string}.
	 * @param ctx the parse tree
	 */
	void enterStringSingleElement(calcParser.StringSingleElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringSingleElement}
	 * labeled alternative in {@link calcParser#string}.
	 * @param ctx the parse tree
	 */
	void exitStringSingleElement(calcParser.StringSingleElementContext ctx);
}