import java.util.Scanner;

public class Q10844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int D[][] = new int[101][10];
        D[1][0] = 0;
        for (int i = 1 ; i < 10 ; i++)
            D[1][i] = 1;
        int n = scanner.nextInt();
        for (int i = 2 ; i <= n ; i++) {
            for (int j = 0 ; j < 10 ; j++) {
                if (j == 0)
                    D[i][j] = D[i-1][1] % 1000000000;
                else if (j == 9)
                    D[i][j] = D[i-1][8] % 1000000000;
                else
                    D[i][j] = (D[i-1][j-1] + D[i-1][j+1]) % 1000000000;
            }
        }
        int x = 0;
        for (int i = 0 ; i < 10; i++) {
            x = (x + D[n][i]) % 1000000000;
        }
        System.out.println(x%1000000000);
    }
}
