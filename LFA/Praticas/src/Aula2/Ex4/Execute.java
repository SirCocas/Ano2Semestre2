import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import java.util.Stack;


public class Execute extends CalculatorBaseListener {
   Stack <Object> stack = new Stack<>();

   @Override public void exitStat(CalculatorParser.StatContext ctx) {
      System.out.println(stack.pop());
   }

   @Override public void exitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      stack.push(doMath(Double.parseDouble(stack.pop().toString()),Double.parseDouble(stack.pop().toString()), ctx.op.getText().toCharArray()[0]));
   }


   @Override public void exitExprPositive(CalculatorParser.ExprPositiveContext ctx) {
      stack.push(0+(Double)stack.pop());
   }

   @Override public void exitExprParent(CalculatorParser.ExprParentContext ctx) {
      stack.push(stack.pop());
   }

   @Override public void exitExprNegative(CalculatorParser.ExprNegativeContext ctx) {
      stack.push(0-(Double)stack.pop());
   }

   @Override public void exitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      stack.push(Integer.parseInt(ctx.getText()));
   }

   @Override public void exitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      stack.push(doMath(Double.parseDouble(stack.pop().toString()),Double.parseDouble(stack.pop().toString()), ctx.op.getText().toCharArray()[0]));
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
