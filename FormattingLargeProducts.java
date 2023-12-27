package Ibm;

public class FormattingLargeProducts {
    public static void main(String[] args) {
        String s = format(3, 10);
        System.out.print(s);
    }

    public static String format(int a, int b) {
        long res = 1;
        int power = 0;

        for (int i = a; i <= b; i++) {
            res = res * i;

            // Count trailing zeros
            while (res % 10 == 0 && res != 0) {
                power += 1;
                res = res / 10;
            }
        }

        return res + " * 10^" + power;
    }
}
