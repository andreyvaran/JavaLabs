package com.lab2;

import java.util.ArrayList;
import java.util.List;


public class PolandNotation {
    public static void main(String[] args) {

        String expression = "   1   +  (     (2      +3)*  4) -5\n";
        List<String> arrayExper = validateToList(expression);
        System.out.println("Массив из выражения ;" + arrayExper);
        List<String> polis = listToPOLIS(arrayExper);
        System.out.println("ПОЛИЗ :" + polis);
        System.out.printf("Результат выражения =%d", calculate(polis));

    }

    /**
     * @param list Массив строк в которых содержатся операции и операнды
     * @return ПОЛИЗ
     */
    public static List<String> listToPOLIS(List<String> list) {
        Stack<String> operand = new StackOnList();

        List<String> s2 = new ArrayList<String>();
        for (String item : list) {
//            System.out.println(s2);
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                operand.add(item);
            } else if (item.equals(")")) {
                while (!operand.get().equals("(")) {

                    s2.add(operand.pop());
//                    System.out.println(s2);
                }
                operand.pop();
            } else {
                while (!operand.isEmpty() && Operation.getValue(operand.get()) >= Operation.getValue(item)) {
                    s2.add(operand.pop());
                }
                operand.add(item);
            }
        }
//        System.out.println(operand);
        while (!operand.isEmpty()) {
            s2.add(operand.pop());
        }
//        System.out.println(s2);
        return s2;

    }


    /**
     * Преобразование инфиксного выражения в список постфиксных выражений
     *
     * @param s
     * @return
     */
    public static List<String> validateToList(String s) {
        // Определяем список, помещаем инфиксное выражение
        s = s.replaceAll(" ", "").strip();
        List<String> list = new ArrayList<String>();
        int i = 0;
        String str;
        char c;

        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                list.add("" + c);
                i++;
            } else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                list.add(str);
            }
        } while (i < s.length());
        return list;
    }

    /**
     *
     * @param polis ПОЛИЗ выражение
     * @return Ответ
     */
    public static int calculate(List<String> polis) {
        Stack<String> stack = new StackOnList();

        for (String item : polis) {
            if (item.matches("\\d+")) {
                stack.add(item);
            } else {
                int num2 = Integer.parseInt((String) stack.pop());
                int num1 = Integer.parseInt((String) stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("Неправильный оператор");
                }
                stack.add(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}

class Operation {
    public static int getValue(String operation) {
        switch (operation) {
            case "+":
                return 1;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 2;
            case "^":
                return 3;
                /// TODO: 13.05.2022   Перед заливкой на гит добавить обработку большего количества операций
            default:
                break;
        }
        return -1;

    }
}

