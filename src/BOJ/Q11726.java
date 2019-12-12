import java.util.Scanner;

public class Q11726 {
    public static void main(String[] args) {
        int[] D = new int[1001];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        D[1] = 1;
        D[2] = 2;
        for (int i = 3 ; i <=n ; i++){
            D[i] = (D[i-1] + D[i-2])%10007;
        }
        System.out.println(D[n] % 10007);
    }
}
