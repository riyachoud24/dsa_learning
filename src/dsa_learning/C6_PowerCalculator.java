package dsa_learning;

//QUESTION 3
public class C6_PowerCalculator {

    public static double power(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            double halfPower = power(x, n / 2);
            return halfPower * halfPower;
        } 

        else {
            if (n > 0) {
                return x * power(x, n - 1);
            } else {
                return 1 / x * power(x, n + 1);
            }
        }
    }

    public static void main(String[] args) {
        double x = 2;
        int n = 10;
        System.out.println(x + " raised to the power of " + n + " is " + power(x, n));
    }
}

