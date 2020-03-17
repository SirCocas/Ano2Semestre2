// Generated from question.g4 by ANTLR 4.8
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link questionParser}.
 */
public interface questionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link questionParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(questionParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link questionParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(questionParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link questionParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(questionParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link questionParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(questionParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link questionParser#answers}.
	 * @param ctx the parse tree
	 */
	void enterAnswers(questionParser.AnswersContext ctx);
	/**
	 * Exit a parse tree produced by {@link questionParser#answers}.
	 * @param ctx the parse tree
	 */
	void exitAnswers(questionParser.AnswersContext ctx);
	/**
	 * Enter a parse tree produced by {@link questionParser#answer}.
	 * @param ctx the parse tree
	 */
	void enterAnswer(questionParser.AnswerContext ctx);
	/**
	 * Exit a parse tree produced by {@link questionParser#answer}.
	 * @param ctx the parse tree
	 */
	void exitAnswer(questionParser.AnswerContext ctx);
}