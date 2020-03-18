public class Execute2 extends questionBaseVisitor<String> {

   @Override public String visitMain(questionParser.MainContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitQuestion(questionParser.QuestionContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitAnswers(questionParser.AnswersContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitAnswer(questionParser.AnswerContext ctx) {
      return visitChildren(ctx);
   }
}
