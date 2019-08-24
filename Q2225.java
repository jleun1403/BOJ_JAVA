import java.util.Scanner;

public class Q2225 {
    public static void main(String[] args) {
        final int MAX = 1000000000;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] D = new int[201][201];
        for (int i = 0 ; i <= 200 ; i++) {
            D[i][1] = 1;
            D[0][i] = 1;
        }
        for (int i = 1 ; i <= n ; i++) {
            for (int j = 2 ; j <= k ; j++) {
                int sum = 0;
                for (int p = 0 ; p <= i ; p++) {
                    sum = (D[i-p][j-1] % MAX  + sum ) % MAX;
                }
                D[i][j] = sum % MAX;
            }
        }
        System.out.println(D[n][k]);
    }
}
