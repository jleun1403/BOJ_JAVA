import java.util.Scanner;

public class Q2156 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] D = new int[n+1];
        int[] Dnew = new int[n+1];
        D[0] = 0;
        for (int i = 1 ; i <= n ; i++)
            D[i] = scanner.nextInt();
        if (n >= 2)
            Dnew[2] = D[2] + D[1];
        Dnew[1] = D[1];
        for (int i = 3 ; i <= n ; i++) {
            int result = Math.max(D[i-1] + Dnew[i-3] + D[i], Math.max(Dnew[i-2] + D[i], Dnew[i-1]));
            Dnew[i] = result;
        }
        System.out.println(Dnew[n]);

    }
}
