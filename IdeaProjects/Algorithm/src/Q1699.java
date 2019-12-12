import java.util.Scanner;

public class Q1699 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] D = new int [n+1];
        D[0] = 0;
        D[1] = 1;
        for (int i = 2 ; i <=n ;i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1 ; j <= Math.sqrt(i); j++) {
                if (D[i - j*j] < min)
                    min = D[i - j*j];
            }
            D[i] = min + 1;
        }
        System.out.println(D[n]);
    }
}
