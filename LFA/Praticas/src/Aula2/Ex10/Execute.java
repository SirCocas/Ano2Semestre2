import java.util.*;

public class Execute extends calcBaseVisitor<LinkedList> {
   HashMap<String, LinkedList> variables = new HashMap<>();

   @Override public LinkedList visitMain(calcParser.MainContext ctx) {
      return visitChildren(ctx);
   }

   @Override public LinkedList visitStat(calcParser.StatContext ctx) {
      String toPrint ="[";
      var result = visitChildren(ctx);
      if(! result.isEmpty()){
         Iterator it = result.iterator();
         toPrint+=it.next().toString();
         while(it.hasNext()){
            toPrint+= ","+ it.next().toString();
         }
      }
      toPrint+=']';
      System.out.println("Result: "+toPrint);
      return null;
   }

   @Override public LinkedList visitAtrib(calcParser.AtribContext ctx) {
      String name = ctx.variable.getText();
      var toReturn = visit(ctx.math());
      variables.put(name, toReturn);
      return toReturn;
   }

   @Override public LinkedList visitDivision(calcParser.DivisionContext ctx) {
      var first = visit(ctx.exp1);
      var second = visit(ctx.exp2);
      LinkedList<String> toReturn = new LinkedList<>();
      Iterator it = first.iterator();
      while(it.hasNext()){
         String current = it.next().toString();
         if(! second.contains(current))
            toReturn.add(current);
      }
      return toReturn;
   }

   @Override public LinkedList visitSingleGroup(calcParser.SingleGroupContext ctx) {
      return visit(ctx.group());
   }

   @Override public LinkedList visitInterception(calcParser.InterceptionContext ctx) {
      var first = visit(ctx.exp1);
      var second = visit(ctx.exp2);
      LinkedList<String> toReturn = new LinkedList<>();
      Iterator it = first.iterator();
      while(it.hasNext()){
         String obj = it.next().toString();
         if(second.contains(obj))
            toReturn.add(obj);
      }
      return toReturn;
   }

   @Override public LinkedList visitParenthesisSequence(calcParser.ParenthesisSequenceContext ctx) {
      return visit(ctx.math());
   }

   @Override public LinkedList visitVariable(calcParser.VariableContext ctx) {
      String name = ctx.variable.getText();
      return variables.get(name);
   }

   @Override public LinkedList visitSum(calcParser.SumContext ctx) {
      var firstPart = visit(ctx.exp1);
      var secondPart = visit(ctx.exp2);
      Iterator it = firstPart.iterator();
      LinkedList<String> toReturn = new LinkedList<>();
      while(it.hasNext()){
         String current = it.next().toString();
         if(! toReturn.contains(current))
            toReturn.add(current);
      }
      it = secondPart.iterator();
      while(it.hasNext()){
         String current = it.next().toString();
         if(! toReturn.contains(current))
            toReturn.add(current);
      }
      return toReturn;
   }

   @Override public LinkedList visitGroup(calcParser.GroupContext ctx) {
      return visit(ctx.sequence());
   }

   @Override public LinkedList visitSequenceOfStrings(calcParser.SequenceOfStringsContext ctx) {
      return visit(ctx.string());
   }

   @Override public LinkedList visitSequenceOfInts(calcParser.SequenceOfIntsContext ctx) {
      return visit(ctx.ints());
   }

   @Override public LinkedList visitIntSingleElement(calcParser.IntSingleElementContext ctx) {
      String element = ctx.number.getText();
      LinkedList<String> toReturn = new LinkedList<>();
      toReturn.add(element);
      return toReturn;
   }

   @Override public LinkedList visitIntSeveralElements(calcParser.IntSeveralElementsContext ctx) {
      var toReturn = visit(ctx.ints());
      toReturn.add(ctx.number.getText());
      return toReturn;
   }

   @Override public LinkedList visitStringSeveralElements(calcParser.StringSeveralElementsContext ctx) {
      var toReturn = visit(ctx.string());
      toReturn.add(ctx.letter.getText());
      return toReturn;
   }

   @Override public LinkedList visitStringSingleElement(calcParser.StringSingleElementContext ctx) {
      LinkedList<String> toReturn = new LinkedList<>();
      String elem = ctx.letter.getText();
      toReturn.add(elem);
      return toReturn;
   }
}
