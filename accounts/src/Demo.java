public class Demo {
    public static void main(String[] args) {
    /**
     * Adds two numbers together.
     * @param a the first number
     * @param b the second number
     * @return the sum of the two numbers
     */
    public static int add(int a, int b) {
        System.out.println("Sum: " + (a+b));
        return a + b;
    }

    /**
     * Subtracts one number from another
     * @param a the first number
     * @param b the second number
     * @return the difference between the two numbers
     */
    public static int subtract(int a, int b) {
        System.out.println("Difference: " + (a-b));
        return a - b;
    }

    /**
     * Multiplies two numbers
     * @param a the first number
     * @param b the second number
     * @return the product of the two numbers
     */
    public static int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides one number by another
     * @param a the first number
     * @param b the second number
     * @return the quotient of the two numbers
     */
    public static int divide(int a, int b) {
        return a / b;
    }


    }
}