import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calculator {
    /**
     * Performs calculations on Roman numerals and prints the result.
     * <p>
     * If either of the numbers are not Roman numerals, or if the operation is
     * unrecognized, prints an error message.  Otherwise, performs the
     * operation and prints the result in Roman numerals.  If the result is
     * less than 1 or larger than 3999, prints a message indicating this
     * instead.
     *
     * @param leftNumber  The left operand, in Roman numerals.
     * @param operation   The operator, which may be,
     *                    - "+" for addition,
     *                    - "-" for subtraction,
     *                    - "*" for multiplication,
     *                    - "/" for (integer) division
     * @param rightNumber The right operand.
     */
    public static void calculate(String leftNumber, String operation, String rightNumber) {

        Numerals leftInt, rightInt;
        int resultInt = 0;
        leftInt = new Numerals(leftNumber);
        rightInt = new Numerals(rightNumber);
        boolean isOneTupe = (leftInt.isRoman && rightInt.isRoman) || ((!leftInt.isRoman && !rightInt.isRoman));
        if (!isOneTupe) {
            System.out.println("Uze one type of numerals");
        }
        boolean opValid = parseOperation(operation) && leftInt.isValid && rightInt.isValid && isOneTupe;

        // This block performs the operation if user input is valid
        if (opValid) {
            resultInt = operate(operation, leftInt.value, rightInt.value);

            // If result is in range, formats to roman numeral and displays to console
            if (resultInt < 0 || resultInt >= 4000) {
                System.out.println("result out of range");
            } else if (rightInt.isRoman && leftInt.isRoman) {
                System.out.println(RomanNumerals.format(resultInt));
            } else {
                System.out.println(resultInt);
            }
        }
    }

    public static boolean parseOperation(String operation) {

        if (operation.equals("+") || operation.equals("-") || operation.equals("*") ||
                operation.equals("/")) {
            return true;
        } else {
            System.out.println("invalid operation");
            return false;
        }
    }


    public static int operate(String operation, int leftInt, int rightInt) {
        int resultInt = 0;
        //Addition
        if (operation.equals("+")) {
            resultInt = leftInt + rightInt;
        }

        //Subtraction
        else if (operation.equals("-")) {
            resultInt = leftInt - rightInt;
        }

        //Multiplication
        else if (operation.equals("*")) {
            resultInt = leftInt * rightInt;
        }

        //Division
        else if (operation.equals("/")) {
            resultInt = leftInt / rightInt;
        }
        return resultInt;
    }
    /**
     * @note You do not need to understand how this function works.
     */
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Loop forever.
        while (true) {
            // Show the prompt.
            System.out.println("Type as \"a + b\",where a,b is Arabic or Roman numerals");
            System.out.print("> ");
            // Read a line of input.
            final String line = reader.readLine();
            if (line.length() == 0) {
                System.out.println("done");
                break;
            }
            // Scan the line into three parts: two numbers with an operator between them.
            final Scanner scanner = new Scanner(line);
            final String leftNumber, operation, rightNumber;
            try {
                leftNumber = scanner.next();
                operation = scanner.next();
                rightNumber = scanner.next();
            } catch (NoSuchElementException e) {
                System.err.println("syntax error");
                System.out.println();
                continue;
            }
            // Perform the calculation and show the result.
            calculate(leftNumber, operation, rightNumber);
            System.out.println();
        }
    }
}
