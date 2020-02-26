package Aula1;

public class Operation {
    public Object leftNode;
    public Object rightNode;
    public String op;

    public Operation() {
        leftNode = null;    //can be either an int or another operation
        rightNode = null;
        op = "";
    }

    @Override
    public String toString() {
        String out = "";
        if (leftNode != null)
            out += leftNode.toString();
        out += " " + op + " ";
        if (rightNode != null)
            out += rightNode.toString();
        return out;
    }
}
