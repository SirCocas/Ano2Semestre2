public class Execute extends SuffixCalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(SuffixCalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitStat(SuffixCalculatorParser.StatContext ctx) {
      System.out.println(visit(ctx.expr()));
      return null;
      //return visitChildren(ctx);
   }

   @Override public Double visitExprNumber(SuffixCalculatorParser.ExprNumberContext ctx) {
      return Double.parseDouble(ctx.getText());
   }

   @Override public Double visitExprSuffix(SuffixCalculatorParser.ExprSuffixContext ctx) {
      return doMath(visit(ctx.op1), visit(ctx.op2), ctx.op.getText().toCharArray()[0]);
      //return visitChildren(ctx);
   }

   public Double doMath(Double number1, Double number2, char operator){
      switch(operator){
         case '*': return number1*number2;
         case '/': return number1/number2;
         case '-': return number1-number2;
         case '+': return number1+number2;
         default: return null;
      }
   }
}
