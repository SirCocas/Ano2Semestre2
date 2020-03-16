public class Execute extends CalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitStat(CalculatorParser.StatContext ctx) {
      System.out.println(visit(ctx.expr()));
      return null;
      ///return visitChildren(ctx);
   }

   @Override public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      return doMath(visit(ctx.op1), visit(ctx.op2), ctx.op.getText().toCharArray()[0]);
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return(visit(ctx.expr()));
      //return visitChildren(ctx);
   }

   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Double.parseDouble(ctx.getText());
   }

   @Override public Double visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      return doMath(visit(ctx.op1), visit(ctx.op2), ctx.op.getText().toCharArray()[0]);
   }

   public Double doMath(Double number1, Double number2, char operator){
      switch(operator){
         case '*': return number1*number2;
         case '/': return number1/number2;
         case '-': return number1-number2;
         case '+': return number1+number2;
         case '%': return number1%number2;
         default: return 0.0;
      }
   }
   @Override public Double visitExprNegative(CalculatorParser.ExprNegativeContext ctx) {
      return 0-visitChildren(ctx);
   }
   @Override public Double visitExprPositive(CalculatorParser.ExprPositiveContext ctx) {
      return 0+visitChildren(ctx);
   }
}
