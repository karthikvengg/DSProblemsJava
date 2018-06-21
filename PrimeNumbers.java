package test;

public class PrimeNumbers {

    public static void main(String[] args) {
        int n = 11;
        for (int j = 2; j <= n; j++) {
            boolean flag = false;
            int i;
            for (i = 2; i < j; i++) {
                if (j % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println(i + " ");

        }
    }
}
