import java.util.*;

public class MyCSVVisitor extends csvBaseVisitor<Object> {
   int currentLine = 0;
   HashMap<Integer, HashMap<String,String>> table = new HashMap<Integer, HashMap<String, String>>();
   HashMap<Integer,String> header = new HashMap<>();
   @Override public Object visitMain(csvParser.MainContext ctx) {
      return visitChildren(ctx);
   }

   @Override public Object visitHeader(csvParser.HeaderContext ctx) {
      String [] line = ctx.getText().split(",");
      for (int i = 0; i < line.length; i++) {
         header.put(i, line[i].trim());
      }
      return visitChildren(ctx);
   }

   @Override public Object visitRow(csvParser.RowContext ctx) {
      String [] contents = ctx.getText().split(",");
      HashMap<String,String> lineContent = new HashMap<>();
      for (int i = 0; i < contents.length; i++) {
         lineContent.put(header.get(i), contents[i]);
      }
      table.put(currentLine,lineContent);
      currentLine++;
      return visitChildren(ctx);
   }

   @Override public Object visitField(csvParser.FieldContext ctx) {
      return table;
   }
}
