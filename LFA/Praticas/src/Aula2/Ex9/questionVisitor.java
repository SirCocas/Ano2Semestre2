// Generated from question.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link questionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface questionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link questionParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(questionParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link questionParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(questionParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link questionParser#answers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswers(questionParser.AnswersContext ctx);
	/**
	 * Visit a parse tree produced by {@link questionParser#answer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnswer(questionParser.AnswerContext ctx);
}