import java.util.Scanner;

public class Q14712 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] D = new int[26][26];
        for (int i = 1 ; i <= 25 ; i++) {
            D[1][i] = D[i][1] = (int)Math.pow(2, i);
        }
        if ((m == 1) || (n == 1)) {
            System.out.println(D[m][n]);
            return;
        }
        D[2][2] = 15;
        for (int i = 3 ; i <= n ; i++)
            D[2][i] = 3*D[2][i-1] + 3*D[2][i-2];

        for (int i = 3 ; i <= m ; i++) {
            D[i][n] = D[i-2][n] + D[2][n];
        }
        System.out.println(D[m][n]);
    }
}
