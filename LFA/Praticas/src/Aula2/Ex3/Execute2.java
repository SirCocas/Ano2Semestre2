public class Execute2 extends CalculatorBaseVisitor<Double> {

   @Override public Double visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitStat(CalculatorParser.StatContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitExprPositive(CalculatorParser.ExprPositiveContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitExprNegative(CalculatorParser.ExprNegativeContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      return visitChildren(ctx);
   }
}
