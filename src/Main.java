import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите пример: ");
        String input = scn.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        int a1;
        int b1;
        String operator;
        String resault;
        boolean isRom;
        String[] operands = input.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Должно быть не больше двух знаков");
        operator = detect(input);
        if (Roman.isRom(operands[0]) && Roman.isRom(operands[1])) {
            a1 = Roman.conToArab(operands[0]);
            b1 = Roman.conToArab(operands[1]);
            isRom = true;
        } else if (!Roman.isRom(operands[0]) && !Roman.isRom(operands[1])) {
            a1 = Integer.parseInt(operands[0]);
            b1 = Integer.parseInt(operands[1]);
            isRom = false;
        } else {
            throw new Exception("Должен быть один формат.");
        }
        if (a1 > 10 && b1 > 10) {
            throw new Exception("Не может быть больше 10");
        }
        int arab = calculate(a1, b1, operator);
        if (isRom) {
            if (arab <= 0) {
                throw new Exception("Должно быть больше нуля.");
            }
            resault = Roman.conToRom(arab);
        } else {
            resault = String.valueOf(arab);
        }

        return resault;
    }

    static String detect(String exprisiv) {
        if (exprisiv.contains("+")) return "+";
        else if (exprisiv.contains("-")) return "-";
        else if (exprisiv.contains("*")) return "*";
        else if (exprisiv.contains("/")) return "/";
        else return null;
    }

    static int calculate(int a, int b, String operator) {
        if (operator.equals("+")) return a + b;
        else if (operator.equals("-")) return a - b;
        else if (operator.equals("*")) return a * b;
        else return a / b;
    }
}


class Roman {
    static String[] rimNumber = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};


    public static boolean isRom(String str) {
        for (int i = 0; i < rimNumber.length; i++) {
            if (str.equals(rimNumber[i])) {
                return true;
            }
        }
        return false;
    }

    public static String conToRom(int arab) {
        return rimNumber[arab];
    }

    public static int conToArab(String rom) {
        for (int i = 0; i < rimNumber.length; i++) {
            if (rom.equals(rimNumber[i])) {
                return i;
            }
        }
        return -1;
    }
}
