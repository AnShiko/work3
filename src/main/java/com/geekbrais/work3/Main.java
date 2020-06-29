package com.geekbrais.work3;

public class Main {

    public static void main(String[] args) throws MyArrayException {
        String s = "1 2 3 4\n5 6 7 8\n9 10 11 12\n13 14 15 16";

        String[][] stringArray = convertStringToArray(s);
        System.out.println(calculate(stringArray));
    }

    static String[][] convertStringToArray(String s) throws MyArrayException {
        String tmp = s + "\n";
        for (int i = 0, space = 0, n = 0; i < tmp.length(); i++) {
            if (tmp.charAt(i) == ' ') space++;
            if (tmp.charAt(i) == '\n') {
                if (space == 3) space = 0;
                else throw new MyArrayException("размер массива указан неверно");
            }
        }

        int length = s.split("\n").length;
        String[][] result = new String[length][length];
        String[] clearN = s.split("\n");

        for (int i = 0; i < length; i++) {
            String[] clearSpaces = clearN[i].split(" ");
            for (int j = 0; j < length; j++) {
                result[i][j] = clearSpaces[j];
            }
        }

        return result;
    }

    static double calculate(String[][] s) {
        int sum = 0;

        for (String[] s1 : s) {
            for (String s2 : s1) {
                try {
                    sum += Integer.parseInt(s2);
                } catch (NumberFormatException e) {
                    System.out.println("тип одного из значений массива ошибочен");
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }

        return sum ;
    }
}

