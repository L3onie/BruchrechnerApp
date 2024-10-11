package bruchrechner;

public class Calculator {

    // Addition von zwei Brüchen
    public int[] add(int num1, int den1, int num2, int den2) {
        int resultNum;
        int resultDen;

        if (den1 == den2) {
            resultNum = num1 + num2;
            resultDen = den1;
        } else {
            resultNum = num1 * den2 + num2 * den1;
            resultDen = den1 * den2;
        }

        return new int[]{resultNum, resultDen};
    }

    // Subtraktion von zwei Brüchen
    public int[] subtract(int num1, int den1, int num2, int den2) {
        int resultNum;
        int resultDen;

        if (den1 == den2) {
            resultNum = num1 - num2;
            resultDen = den1;
        } else {
            resultNum = num1 * den2 - num2 * den1;
            resultDen = den1 * den2;
        }

        return new int[]{resultNum, resultDen};
    }

    // Multiplikation von zwei Brüchen
    public int[] multiply(int num1, int den1, int num2, int den2) {
        int resultNum = num1 * num2;
        int resultDen = den1 * den2;
        return new int[]{resultNum, resultDen};
    }

    // Division von zwei Brüchen
    public int[] divide(int num1, int den1, int num2, int den2) throws ArithmeticException {
        if (num2 == 0) {
            throw new ArithmeticException("Division durch null");
        }
        int resultNum = num1 * den2;
        int resultDen = den1 * num2;
        return new int[]{resultNum, resultDen};
    }
}
