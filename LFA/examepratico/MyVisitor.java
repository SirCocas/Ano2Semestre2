import java.util.*;


public class MyVisitor extends StrBaseVisitor<String> {

	HashMap<String, String> variables = new HashMap<>();
	Scanner sc = new Scanner(System.in);

   @Override public String visitDefinition(StrParser.DefinitionContext ctx) {
	   String varname = ctx.ID().getText();
	   String toSave = visit(ctx.string());
	   variables.put(varname, toSave);
      return toSave;
   }

   @Override public String visitPrint(StrParser.PrintContext ctx) {
	   String toPrint = visit(ctx.string());
	   System.out.println(toPrint);
      return toPrint;   //arbitrário, este método seria void
   }

   @Override public String visitInput(StrParser.InputContext ctx) {
      String toPrint = visit(ctx.string());
	   System.out.print(toPrint);
	   String toReturn = "";
	   do{
		   toReturn+= sc.nextLine();
	   }while(toReturn.isEmpty());
      return toReturn;
   }

   @Override public String visitSubstitution(StrParser.SubstitutionContext ctx) {
      String base = visit(ctx.string(0));
      String toReplace = visit(ctx.string(1));
      String with = visit(ctx.string(2));
      String toReturn = base.replaceAll(toReplace,with);
      return toReturn;
   }

   @Override public String visitStringIsString(StrParser.StringIsStringContext ctx) {
      String toReturn = ctx.STRING().getText().replaceAll("\"","");
      return toReturn;
   }

   @Override public String visitStringIsVariable(StrParser.StringIsVariableContext ctx) {
	   String varname = ctx.ID().getText();
	   if(! variables.containsKey(varname)){
		System.out.println("Erro: variável \""+varname+"\" não definida");
		System.exit(-1);
	   }
	   return variables.get(varname);
   }

   @Override public String visitAddString(StrParser.AddStringContext ctx) {
	   String first = visit(ctx.string(0));
	   String second = visit(ctx.string(1));
	   
      return first+second;
   }
   
   @Override public String visitStatementIsDef(StrParser.StatementIsDefContext ctx) {
      return visit(ctx.definition());
   }

   @Override public String visitStatementIsPrint(StrParser.StatementIsPrintContext ctx) {
      return visit(ctx.print());
   }
 

   @Override public String visitStringIsInput(StrParser.StringIsInputContext ctx) {
      return visit(ctx.input());
   }

   @Override public String visitStringIsParent(StrParser.StringIsParentContext ctx) {
      return visit(ctx.string());
   }
}
