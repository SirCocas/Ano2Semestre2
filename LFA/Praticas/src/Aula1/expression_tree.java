package Aula1;

import java.util.Iterator;
import java.util.LinkedList;

public class expression_tree {
    public Operation firstNode;
    LinkedList<Operation> obj = new LinkedList<>();

    public expression_tree() {
        firstNode = new Operation();
    }

    public void putNumber(double nextDouble) {
        Operation op = new Operation();
        putNumber(nextDouble, firstNode, obj.iterator());
    }

    private int putNumber(double nextDouble, Operation firstNode, Iterator iterator) {
        if (firstNode.leftNode == null) {
            firstNode.leftNode = nextDouble;
            return 1;
        }
        if (firstNode.rightNode == null) {
            firstNode.rightNode = nextDouble;
            return 1;
        }
        if (firstNode.leftNode.getClass().getSimpleName().equals("Operation")) {
            return putNumber(nextDouble, (Operation) firstNode.leftNode, iterator);
        }
        if (firstNode.rightNode.getClass().getSimpleName().equals("Operation")) {
            return putNumber(nextDouble, (Operation) firstNode.rightNode, iterator);
        }
        if (iterator.hasNext()) {
            return putNumber(nextDouble, (Operation) iterator.next(), iterator);
        }
        Operation newOp = new Operation();
        newOp.rightNode = nextDouble;
        obj.add(newOp);
        System.out.println("added new node, check putNumber function");
        return 1;
    }

    public void putSignal(String next) {
        putSignal(next, firstNode, obj.iterator());
    }

    private int putSignal(String next, Operation firstNode, Iterator<Operation> iterator) {
        if (firstNode.op.equals("")) {
            firstNode.op = next;
            return 1;
        }
        if (firstNode.rightNode != null) {
            if (firstNode.rightNode.getClass().getSimpleName().equals("Operation"))
                return putSignal(next, (Operation) firstNode.rightNode, iterator);
        } else {
            firstNode.rightNode = new Operation();
            return (putSignal(next, (Operation) firstNode.rightNode, iterator));
        }
        if (firstNode.leftNode != null) {
            if (firstNode.leftNode.getClass().getSimpleName().equals("Operation"))
                return putSignal(next, (Operation) firstNode.leftNode, iterator);
        } else {
            firstNode.leftNode = new Operation();
            return putSignal(next, (Operation) firstNode.leftNode, iterator);
        }
        if (iterator.hasNext()) {
            return putSignal(next, iterator.next(), iterator);
        }
        Operation newOp = new Operation();
        newOp.op = next;
        obj.add(newOp);
        System.out.println("new node was created, check the signal function");
        return 1;
    }

    public String print() {
        return print(firstNode);
    }

    private String print(Operation firstNode) {
        final String[] state = {""};
        state[0] += firstNode.toString();
        obj.forEach(e -> {
            state[0] += e.toString() + " ";
        });
        return state[0];

    }

    public double eval() {
        return eval(firstNode);
    }

    private double eval(Operation firstNode) {
        double firstPart = 0;
        double secondPart = 0;
        if (firstNode.rightNode.getClass().getSimpleName().equals("Operation"))
            firstPart = eval((Operation) firstNode.rightNode);
        else
            firstPart = (double) firstNode.rightNode;
        if (firstNode.leftNode.getClass().getSimpleName().equals("Operation"))
            secondPart = eval((Operation) firstNode.leftNode);
        else
            secondPart = (double) firstNode.leftNode;
        String toEvaluate = firstPart + " " + firstNode.op + " " + secondPart;
        return eval(toEvaluate);

    }

    private double eval(String toEvaluate) {
        String[] values = toEvaluate.split(" ");
        return calculate(Double.parseDouble(values[0]), Double.parseDouble(values[2]), values[1]);
    }

    private static double calculate(double firstNum, double secondNum, String operand) {
        switch (operand.toCharArray()[0]) {
            case '+':
                return firstNum + secondNum;
            case '*':
                return firstNum * secondNum;
            case '-':
                return firstNum - secondNum;
            case '/':
                return firstNum / secondNum;
        }
        return 0;
    }
}