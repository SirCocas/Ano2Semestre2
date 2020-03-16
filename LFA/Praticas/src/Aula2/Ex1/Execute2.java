public class Execute2 extends HelloBaseVisitor<String> {

   @Override public String visitTop(HelloParser.TopContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitGreetings(HelloParser.GreetingsContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitBye(HelloParser.ByeContext ctx) {
      return visitChildren(ctx);
   }

   @Override public String visitName(HelloParser.NameContext ctx) {
      return visitChildren(ctx);
   }
}
