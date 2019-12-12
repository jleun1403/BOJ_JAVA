import java.util.Scanner;

public class Q2133 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] D = new int[n+1];
        D[0] = 1;
        D[1] = 0;
        if (n == 1) {
            System.out.println(0);
            return;
        }
        D[2] = 3;
        for (int i = 4 ; i <= n ; i = i+2) {
            int x = D[i-2] * 3;
            for (int j = i - 4 ; j >= 0 ; j  = j- 2) {
                x = x + D[j] * 2;
            }
            D[i] = x;
        }
        System.out.println(D[n]);
    }
}
