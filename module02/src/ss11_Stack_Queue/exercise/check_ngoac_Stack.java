package ss11_Stack_Queue.exercise;

import java.util.Scanner;
import java.util.Stack;

public class check_ngoac_Stack {
        private static final char LEFT_BRACKET = '(';
        private static final char RIGHT_BRACKET = ')';
        private static final char ADDITION = '+';
        private static final char SUBTRACTION = '-';
        private static final char MULTIPLICATION = '*';
        private static final char DIVISION = '/';

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input expression: ");
            String input = scanner.nextLine();
            System.out.println(input + " is " + checkBracket(input));
        }

        private static boolean checkBracket(String val) {
            Stack stack = new Stack();
            int left = 0;
            // List<String> tmp= Pattern.compile("").splitAsStream(val).collect(Collectors.toList());
            String[] tmp = val.replaceAll(" ", "").split("");
            int size = tmp.length;

            for (int i = 0; i < size; i++) {
                if (tmp[i].charAt(0) == LEFT_BRACKET) {
                    stack.add(LEFT_BRACKET);
                    left++;

                    // check before left bracket have to operator
                    if (i != 0
                            && tmp[i - 1].charAt(0) != ADDITION
                            && tmp[i - 1].charAt(0) != SUBTRACTION
                            && tmp[i - 1].charAt(0) != DIVISION
                            && tmp[i - 1].charAt(0) != MULTIPLICATION) {
                        return false;
                    }
                }

                if (tmp[i].charAt(0) == RIGHT_BRACKET) {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                        left--;
                    }
                }
            }

            return left == 0;
        }
}
