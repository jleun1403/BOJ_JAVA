import java.util.Scanner;

public class Q2193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long D[][] = new long[91][2];
        D[1][0] = 0; D[1][1] = 1;
        for (int i = 2 ; i <= n ; i++){
            D[i][0] = D[i-1][0] + D[i-1][1];
            D[i][1] = D[i-1][0];
        }
        System.out.println(D[n][0] + D[n][1]);
    }
}
