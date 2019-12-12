import java.util.Scanner;

public class Q11052 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        int[] D = new int[p+1];
        D[0] = 0;
        int p1 = scanner.nextInt();
        D[1] = p1;
        for (int i = 2 ; i <= p ; i++) {
            D[i] = scanner.nextInt();
            for (int j = i-1 ; j > 0 ; j--) {
               if (D[i] < D[i-j] + D[j]) {
                   D[i] = D[i-j] + D[j];
               }
            }
        }
        System.out.println(D[p]);
    }
}
