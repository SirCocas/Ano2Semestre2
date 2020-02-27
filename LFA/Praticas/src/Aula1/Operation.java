package Aula1;

public class Operation {
    public Object leftNode;
    public Object rightNode;
    public String op;

    public Operation() {
        leftNode = null;    //can be either an int or another operation
        rightNode = null;
        op = null;
    }

    @Override
    public String toString() {
        return leftNode.toString() + " " + op + " " + rightNode.toString();
    }

    public void putNumber(double nextDouble) {
        if (leftNode == null) {
            leftNode = nextDouble;
        } else if (rightNode == null) {
            rightNode = nextDouble;
        } else if (rightNode.getClass().getSimpleName().equals("Operation")) {
            ((Operation) rightNode).putNumber(nextDouble);
        } else if (leftNode.getClass().getSimpleName().equals("Operation")) {
            ((Operation) leftNode).putNumber(nextDouble);
        } else {
            System.out.println("Something went wrong in putNumber function");
            System.out.println("Current state:" + this);
            System.out.println("Current double: " + nextDouble);
            System.exit(-1);
        }
    }

    public int putSignal(String next) {
        if (op == null) {
            op = next;
            return 1;
        }
        if (rightNode != null) {
            if (rightNode.getClass().getSimpleName().equals("Operation"))
                return ((Operation) rightNode).putSignal(next);
        }
        if (leftNode != null) {
            if (leftNode.getClass().getSimpleName().equals("Operation"))
                return ((Operation) leftNode).putSignal(next);
        }
        if (rightNode == null) {
            rightNode = new Operation();
            return ((Operation) rightNode).putSignal(next);
        }
        if (leftNode == null) {
            leftNode = new Operation();
            return ((Operation) leftNode).putSignal(next);
        }
        System.out.println("Something went wrong in putSignal function");
        System.exit(-1);
        return -1;
    }


    public String print() {
        return toString();
    }

    public double eval() {
        double leftSide = 0;
        double rightSide = 0;
        if (leftNode.getClass().getSimpleName().equals("Operation"))
            leftSide = ((Operation) leftNode).eval();
        else
            leftSide = (Double) leftNode;
        if (rightNode.getClass().getSimpleName().equals("Operation"))
            rightSide = ((Operation) rightNode).eval();
        else
            rightSide = (Double) rightNode;
        return eval(leftSide, rightSide, op);
    }

    private double eval(double leftSide, double rightSide, String op) {
        switch (op.toCharArray()[0]) {
            case '+':
                return leftSide + rightSide;
            case '*':
                return leftSide * rightSide;
            case '-':
                return leftSide - rightSide;
            case '/':
                return leftSide / rightSide;
        }
        return 0;
    }
}
