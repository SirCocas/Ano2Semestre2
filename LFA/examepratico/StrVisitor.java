// Generated from Str.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link StrParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface StrVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link StrParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(StrParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementIsDef}
	 * labeled alternative in {@link StrParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIsDef(StrParser.StatementIsDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code statementIsPrint}
	 * labeled alternative in {@link StrParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementIsPrint(StrParser.StatementIsPrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(StrParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(StrParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link StrParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(StrParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringIsInput}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringIsInput(StrParser.StringIsInputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code substitution}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubstitution(StrParser.SubstitutionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringIsString}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringIsString(StrParser.StringIsStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringIsVariable}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringIsVariable(StrParser.StringIsVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringIsParent}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringIsParent(StrParser.StringIsParentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addString}
	 * labeled alternative in {@link StrParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddString(StrParser.AddStringContext ctx);
}