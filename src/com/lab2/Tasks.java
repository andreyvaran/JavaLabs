package com.lab2;


import java.util.ArrayList;
import java.util.List;

public class Tasks {

    public static boolean bracketSequence(String expression) {
        Stack bracket = new StackOnArray(expression.length());
        boolean flag_star = false;
        boolean flag_slesh = false;
        boolean flag_begin = false;
        for (String symb : expression.split("")) {
            switch (symb) {
                case "(":
                    bracket.add("(");
                    break;
                case "{":
                    bracket.add("{");
                    break;
                case "[":
                    bracket.add("[");
                    break;
                case ")": {
                    if (bracket.pop() != "(") {
                        return false;
                    }
                    ;
                    break;
                }
                case "]": {
                    if (bracket.pop() != "[") {
                        return false;
                    }
                    ;
                    break;
                }
                case "}": {
                    if (bracket.pop() != "{") {
                        return false;
                    }
                    ;
                    break;
                }
                case "<":
                    bracket.add("<");
                    break;
                case ">": {
                    if (bracket.pop() != "<") {
                        return false;
                    }
                    ;
                    break;
                }

                case "/":
                    if (flag_slesh) {
                        if (bracket.pop() != "§") return false;
                    } else flag_star = true;
                    break;
                case "*": {
                    if (flag_star) {
                        bracket.add("§");
                        flag_star = false;
                    } else {
                        flag_slesh = true;
                    }
                    break;
                }
                default:
                    flag_star = false;
                    flag_slesh = false;
            }
        }
        System.out.println(bracket);
        return bracket.isEmpty();
    }


    public static List<String> polis(List<String> exper) {
        Stack operand = new StackOnList();

        List<String> s2 = new ArrayList<String>();
        for (String item : exper) {
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                operand.add(item);
            } else if (item.equals(")")) {
                while (!operand.get().equals("(")) {
                    s2.add((String) operand.pop());
                }
                operand.pop();
            } else {

                while (operand.size() != 0 && Operation.getValue((String) operand.get()) >= Operation.getValue(item)) {
                    s2.add((String) operand.pop());
                }
                operand.add(item);
            }
        }
        while (operand.isFull()) {
            s2.add((String) operand.pop());
        }
        return s2;
    }
}

//
//class Operation {
//
//    public static int getValue(String operation) {
//        int result = 0;
//        switch (operation) {
//            case "+":
//                result = 1;
//                break;
//            case "-":
//                result = 1;
//                break;
//            case "*":
//                result = 2;
//                break;
//            case "/":
//                result = 2;
//                break;
//            default:
//                break;
//        }
//        return result;
//    }
//}
//
