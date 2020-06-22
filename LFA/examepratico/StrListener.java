// Generated from Str.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link StrParser}.
 */
public interface StrListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link StrParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(StrParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(StrParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementIsDef}
	 * labeled alternative in {@link StrParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatementIsDef(StrParser.StatementIsDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementIsDef}
	 * labeled alternative in {@link StrParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatementIsDef(StrParser.StatementIsDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statementIsPrint}
	 * labeled alternative in {@link StrParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatementIsPrint(StrParser.StatementIsPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statementIsPrint}
	 * labeled alternative in {@link StrParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatementIsPrint(StrParser.StatementIsPrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(StrParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(StrParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(StrParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(StrParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link StrParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(StrParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link StrParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(StrParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringIsInput}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void enterStringIsInput(StrParser.StringIsInputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringIsInput}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void exitStringIsInput(StrParser.StringIsInputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code substitution}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void enterSubstitution(StrParser.SubstitutionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code substitution}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void exitSubstitution(StrParser.SubstitutionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringIsString}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void enterStringIsString(StrParser.StringIsStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringIsString}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void exitStringIsString(StrParser.StringIsStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringIsVariable}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void enterStringIsVariable(StrParser.StringIsVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringIsVariable}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void exitStringIsVariable(StrParser.StringIsVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringIsParent}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void enterStringIsParent(StrParser.StringIsParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringIsParent}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void exitStringIsParent(StrParser.StringIsParentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addString}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void enterAddString(StrParser.AddStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addString}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 */
	void exitAddString(StrParser.AddStringContext ctx);
}