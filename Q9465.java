import java.util.Scanner;

public class Q9465 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();
        for (int test = 0 ; test < testcase ; test++) {
            int n = scanner.nextInt();
            int[][] D = new int[2][n + 1];
            D[0][0] = D[1][0] = 0;
            for (int i = 0 ; i < n ; i++)
                D[0][i+1] = scanner.nextInt();
            for (int i = 0 ; i < n ; i++)
                D[1][i+1] = scanner.nextInt();
            for (int i = 2 ; i <= n ;i++) {
                D[0][i] = Math.max(D[1][i-1] + D[0][i], D[1][i-2] + D[0][i]);
                D[1][i] = Math.max(D[0][i-1] + D[1][i], D[0][i-2] + D[1][i]);
            }
            System.out.println(Math.max(D[0][n], D[1][n]));
        }

    }
}
