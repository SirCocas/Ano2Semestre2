public class Execute extends CalculatorBaseVisitor<String> {

   @Override public String visitProgram(CalculatorParser.ProgramContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitStatExpr(CalculatorParser.StatExprContext ctx) {
      System.out.println(visit(ctx.expr()));
      return null;
   }

   @Override public String visitStatAssign(CalculatorParser.StatAssignContext ctx) {
      System.out.println(visit(ctx.assignment()));
      return null;
   }

   @Override public String visitAssignment(CalculatorParser.AssignmentContext ctx) {
      String varName = ctx.ID().getText();
      String value = visit(ctx.expr());
      return varName+" "+ value+" =";
   }

   @Override public String visitExprAddSub(CalculatorParser.ExprAddSubContext ctx) {
      return visit(ctx.op1)+" "+ visit(ctx.op2)+" "+ctx.op.getText();
   }

   @Override public String visitExprPositive(CalculatorParser.ExprPositiveContext ctx) {
      return visit(ctx.expr())+" !+";
   }

   @Override public String visitExprParent(CalculatorParser.ExprParentContext ctx) {
      return visit(ctx.expr());
   }

   @Override public String visitExprNegative(CalculatorParser.ExprNegativeContext ctx) {
      return visit(ctx.expr())+" !-";
   }

   @Override public String visitExprInteger(CalculatorParser.ExprIntegerContext ctx) {
      return ctx.Integer().getText();
   }

   @Override public String visitExprVariable(CalculatorParser.ExprVariableContext ctx) {
      return ctx.ID().getText();
   }

   @Override public String visitExprMultDivMod(CalculatorParser.ExprMultDivModContext ctx) {
      return visit(ctx.op1)+" "+ visit(ctx.op2)+" "+ctx.op.getText();
   }
}
