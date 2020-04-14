import java.util.HashMap;
import java.util.Scanner;

public class Execute extends FractionsBaseVisitor<Fraction> {
   HashMap<String, Fraction> variables = new HashMap<>();

   @Override public Fraction visitPrintFraction(FractionsParser.PrintFractionContext ctx) {
      Fraction toPrint = visit(ctx.statement());
      System.out.println(toPrint.toString());
      return null;
   }

   @Override public Fraction visitAttribution(FractionsParser.AttributionContext ctx) {
      String name = ctx.Variable().getText();
      Fraction value = visit(ctx.statement());
      variables.put(name, value);
      return value;    //in this language, attributions work much like C's
   }

   @Override public Fraction visitDiv(FractionsParser.DivContext ctx) {
      Fraction first = visit(ctx.statement().get(0));
      Fraction second = visit(ctx.statement().get(1));
      return first.div(second);
   }

   @Override public Fraction visitSub(FractionsParser.SubContext ctx) {
      Fraction first = visit(ctx.statement().get(0));
      Fraction second = visit(ctx.statement().get(1));
      return first.sub(second);
   }

   @Override public Fraction visitParenthesis(FractionsParser.ParenthesisContext ctx) {
      return visit(ctx.statement());
   }

   @Override public Fraction visitMult(FractionsParser.MultContext ctx) {
      Fraction first = visit(ctx.statement().get(0));
      Fraction second = visit(ctx.statement().get(1));
      return first.mult(second);
   }

   @Override public Fraction visitReadString(FractionsParser.ReadStringContext ctx) {
      String textToPrint = ctx.String().getText();
      System.out.print(textToPrint+":");
      Scanner sc = new Scanner(System.in);
      String line = "";
      while(line.isEmpty()){
         line+=sc.next()+" ";
      }
      int upper = Integer.parseInt(line.split(" ")[0]);
      int downer = Integer.parseInt(line.split(" ")[1]);
      return (new Fraction(upper, downer)).reduce();
   }


   @Override public Fraction visitIsVariable(FractionsParser.IsVariableContext ctx) {
      String key = ctx.Variable().getText();
      return variables.get(key);
   }

   @Override public Fraction visitSum(FractionsParser.SumContext ctx) {
      Fraction first = visit(ctx.statement().get(0));
      Fraction second = visit(ctx.statement().get(1));
      return first.add(second);
   }

   @Override public Fraction visitPower(FractionsParser.PowerContext ctx) {
      Fraction frac = visit(ctx.statement());
      Fraction pow = visit(ctx.numbers());
      return frac.pow(pow.upper());
   }

   @Override public Fraction visitReduceFraction(FractionsParser.ReduceFractionContext ctx) {
      Fraction frac = visit(ctx.statement());
      return frac.reduce();
   }

   @Override public Fraction visitNumberIsLiteral(FractionsParser.NumberIsLiteralContext ctx) {
      return new Fraction(Integer.parseInt(ctx.LITERALS().getText()));
   }

   @Override public Fraction visitNegativeNumber(FractionsParser.NegativeNumberContext ctx) {
      Fraction currentNumber = visit(ctx.numbers());
      return new Fraction(-1*currentNumber.upper());
   }

   @Override public Fraction visitFraction(FractionsParser.FractionContext ctx) {
      return new Fraction(visit(ctx.numbers().get(0)).upper(), visit(ctx.numbers().get(1)).upper());
   }
}

class Fraction{
   private int upper;
   private int downer;
   public Fraction(int upper, int downer){
      if(downer == 0){
         System.out.println("Fractions can't have 0 as a denominator");
         System.exit(-1);
      }
      this.upper = upper;
      this.downer = downer;
      this.reduce();
   }
   @Override public String toString(){
      if(downer != 1)
         return upper+"/"+downer;
      return upper+"";
   }
   public Fraction(int value){
      this.upper = value;
      this.downer = 1;
   }
   public Fraction div(Fraction other){
      return (new Fraction(upper*other.downer, downer*other.upper));
   }
   public Fraction reduce(){
      int biggestPos = upper;
      if(upper< downer){
         biggestPos = downer;
      }

      for (int i = biggestPos; i > 1; i--) {
         if(upper%i == 0 && downer%i == 0){
            upper= (int) ((double)upper / (double) i);
            downer= (int) ((double)downer / (double) i);
            return this;
         }
      }
      return this;
   }

   public Fraction sub(Fraction other){
      return (new Fraction (upper*other.downer - other.upper*downer, downer*other.downer));
   }

   public Fraction mult(Fraction other){
      return (new Fraction(upper*other.upper, downer*other.downer));
   }

   public Fraction add(Fraction other){
      return (new Fraction(upper*other.downer + other.upper* downer, downer*other.downer));
   }

   public Fraction pow(int power){
      return new Fraction((int)Math.pow(upper, power), (int)Math.pow(downer, power));
   }
   public int upper(){
      return upper;
   }
   public int downer(){
      return downer;
   }
}
