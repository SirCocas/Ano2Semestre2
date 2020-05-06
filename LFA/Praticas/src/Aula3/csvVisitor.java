// Generated from csv.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link csvParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface csvVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link csvParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(csvParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link csvParser#header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHeader(csvParser.HeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link csvParser#row}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRow(csvParser.RowContext ctx);
	/**
	 * Visit a parse tree produced by {@link csvParser#field}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitField(csvParser.FieldContext ctx);
}