public class Execute2 extends FractionsBaseVisitor<Fraction> {

   @Override public Fraction visitMain(FractionsParser.MainContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitPrintFraction(FractionsParser.PrintFractionContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitAttribution(FractionsParser.AttributionContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitDiv(FractionsParser.DivContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitSub(FractionsParser.SubContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitPureNumber(FractionsParser.PureNumberContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitMult(FractionsParser.MultContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitReadString(FractionsParser.ReadStringContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitIsFraction(FractionsParser.IsFractionContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitIsVariable(FractionsParser.IsVariableContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitSum(FractionsParser.SumContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitPower(FractionsParser.PowerContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitReduceFraction(FractionsParser.ReduceFractionContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitParenthesis(FractionsParser.ParenthesisContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitFraction(FractionsParser.FractionContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitNegativeNumber(FractionsParser.NegativeNumberContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitPositiveNumber(FractionsParser.PositiveNumberContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Fraction visitNumberIsLiteral(FractionsParser.NumberIsLiteralContext ctx) {
      return visitChildren(ctx);
   }
}
