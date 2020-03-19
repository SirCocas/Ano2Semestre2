import java.util.*;

public class Execute extends questionBaseVisitor<String> {
   String currentFamily = "";
   String currentQuestionID = "";
   String currentQuestionText = "";
   HashMap<String, HashMap<String, HashMap<String, Integer>>> questions = new HashMap<>();

   @Override public String visitMain(questionParser.MainContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitQuestion(questionParser.QuestionContext ctx) {
      currentQuestionID = ctx.label.getText();
      currentFamily = ctx.family.getText();
      currentQuestionText = ctx.questionText.getText();
      HashMap<String, Integer> answers = new HashMap<>();
      HashMap<String, HashMap<String, Integer>> answerHolder = new HashMap<>();
      answerHolder.put(currentQuestionID, answers);
      questions.put(currentFamily, answerHolder);
      String answersFromInput = visit(ctx.answers());
      if(questionMain.ID.equals(currentQuestionID) && questionMain.family.equals(currentFamily))
         System.out.println(currentQuestionText+"\n"+answersFromInput);
      return null;
   }

   @Override public String visitAnswers(questionParser.AnswersContext ctx) {
      ctx.answer().forEach(e->{
         visit(e);
      });
      var answers = questions.get(currentFamily).get(currentQuestionID);
      var keySet = answers.keySet().toArray();
      int points = 0;
      String chosenAnswers = "";
      int numberOfAnswers = 0;
      int numberOfAnswersPerQuestion = 4;
      for (int i = 0; i < keySet.length; i++) {
         boolean full = numberOfAnswers== numberOfAnswersPerQuestion;
         if(! full){
            if(answers.get(keySet[i])!= 0 && points == 0){
               points+= answers.get(keySet[i]);
               chosenAnswers+= numberOfAnswers+++") "+keySet[i]+"\n";
            }
            else{
               if(numberOfAnswers != numberOfAnswersPerQuestion -1 && answers.get(keySet[i])== 0){
                  chosenAnswers+= numberOfAnswers+++") "+keySet[i]+"\n";
               }
            }
         }
      }
      return chosenAnswers;
   }

   @Override public String visitAnswer(questionParser.AnswerContext ctx) {
      var answers = questions.get(currentFamily).get(currentQuestionID);
      answers.put(ctx.text.getText(), Integer.parseInt(ctx.points.getText()));
      var asd = questions.get(currentFamily);
      asd.put(currentQuestionID, answers);
      questions.put(currentFamily,asd);
      return "";
   }
}
