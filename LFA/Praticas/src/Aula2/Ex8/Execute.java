import java.util.*;
import java.lang.Math.*;
public class Execute extends CalculatorBaseVisitor<Double> {
   HashMap<String, Double> map = new HashMap<>();
   Stack<String> literals = new Stack<>();
   @Override public Double visitMain(CalculatorParser.MainContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Double visitPrintValue(CalculatorParser.PrintValueContext ctx) {
      System.out.println(visit(ctx.expr()));
      return null;
      //return visitChildren(ctx);
   }

   @Override public Double visitAssignValue(CalculatorParser.AssignValueContext ctx) {
      Double value = visit(ctx.expr());
      String varName = ctx.ID().getText();
      map.put(varName, value);
      System.out.println(varName+" = "+value);
      return null;
      //return visitChildren(ctx);
   }

   @Override public Double visitPrintLiteral(CalculatorParser.PrintLiteralContext ctx) {
      visit(ctx.literals());
      System.out.println(literals.pop());
      return null;
   }

   @Override public Double visitReturnReduction(CalculatorParser.ReturnReductionContext ctx) {
      var fraction = ctx.fraction();
      int upper = Integer.parseInt(fraction.upper.getText());
      int downer = Integer.parseInt(fraction.downer.getText());
      if (downer == upper){
         literals.push("1");
         return null;
      }
      if(downer == 1){
         literals.push(""+upper);
         return null;
      }
      int littlest;
      if(downer > upper)
         littlest = downer;
      else
         littlest = upper;
      for (int i = littlest; i > 1; i--) {
         if(upper % i == 0 && downer % i == 0){
            upper/=i;
            downer /=i;
            break;
         }
      }
      literals.push(upper + "/"+ downer);
      return null;
   }

   @Override public Double visitExpressPositive(CalculatorParser.ExpressPositiveContext ctx) {
      return 0+visit(ctx.expr());
   }

   @Override public Double visitExpressMath(CalculatorParser.ExpressMathContext ctx) {
      return doMath(visit(ctx.val1), visit(ctx.val2), ctx.op.getText().toCharArray()[0]);
   }

   @Override public Double visitExpressFract(CalculatorParser.ExpressFractContext ctx) {
      String[] fraction = ctx.getText().split("/");
      return Double.parseDouble(fraction[0])/ Double.parseDouble(fraction[1]);
   }

   @Override public Double visitExpressInt(CalculatorParser.ExpressIntContext ctx) {
      return Double.parseDouble(ctx.INT().getText());
   }

   @Override public Double visitExpressPower(CalculatorParser.ExpressPowerContext ctx) {
      return Math.pow(visit(ctx.expr()), Integer.parseInt(ctx.INT().getText()));
   }

   @Override public Double visitExpressParent(CalculatorParser.ExpressParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public Double visitExpressNegative(CalculatorParser.ExpressNegativeContext ctx) {
      return 0- visit(ctx.expr());
   }

   @Override public Double visitExpressVar(CalculatorParser.ExpressVarContext ctx) {
      return map.get(ctx.ID().getText());
   }

   @Override public Double visitFraction(CalculatorParser.FractionContext ctx) {
      return Double.parseDouble(ctx.upper.getText())/ Double.parseDouble(ctx.downer.getText());
   }
   public Double doMath(Double number1, Double number2, char operator){
      switch(operator){
         case '*': return number1*number2;
         case '/': return number1/number2;
         case '-': return number1-number2;
         case '+': return number1+number2;
         case ':': return number1/number2;
         default: return 0.0;
      }
   }
}
