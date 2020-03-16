import java.util.*;
public class Execute extends CalculatorBaseVisitor<Double> {
   HashMap<String, Double> map = new HashMap<>();

   @Override public Double visitStatExpr(CalculatorParser.StatExprContext ctx) {
      System.out.println(visit(ctx.expr()));
      return null;
   }

   @Override public Double visitAssignment(CalculatorParser.AssignmentContext ctx) {
      String varName = ctx.ID().getText();
      Double value = visit(ctx.expr());
      map.put(varName,value);
      System.out.println(varName+" = "+value);
      return value;
   }

   @Override public Double visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      return doMath(visit(ctx.op1), visit(ctx.op2), ctx.op.getText().toCharArray()[0]);
   }

   @Override public Double visitExprPositive(CalculatorParser.ExprPositiveContext ctx) {
      return 0+visit(ctx.expr());
   }

   @Override public Double visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Double visitExprNegative(CalculatorParser.ExprNegativeContext ctx) {
      return 0-visit(ctx.expr());
   }

   @Override public Double visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return Double.parseDouble(ctx.Integer().getText());
   }

   @Override public Double visitExprVariable(CalculatorParser.ExprVariableContext ctx) {
      return map.get(ctx.ID().getText());
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
}
