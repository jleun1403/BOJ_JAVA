import java.util.Scanner;

public class Q11057 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] D = new int[1001][10];
        int n = scanner.nextInt();
        for (int i = 0 ; i < 10  ; i++)
            D[1][i] = 1;
        for (int i = 2 ; i <= n ; i++){
            for (int j = 0 ; j <10 ; j++) {
                for (int k = 0 ; k <= j ; k++)
                    D[i][j] += D[i-1][k] % 10007;
            }
        }
        int x = 0;
        for (int i = 0 ; i < 10 ; i++)
            x = x + D[n][i] % 10007;
        System.out.println(x % 10007);
     }
}
