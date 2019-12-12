import java.util.Scanner;

public class Q11053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] D = new int[n + 1];
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            D[i] = scanner.nextInt();
        }
        count[1] = 1;
        for (int i = 2; i <= n ; i++) {
            int min = 0;
            for (int j = 1; j < i ; j++) {
                if (D[j] < D[i]){
                    if (count[j] > min)
                        min = count[j];
                }
            }
            count[i] = min + 1;
        }
        System.out.println(max(count, 1, n+1));
    }

    public static int max(int[] A, int i, int j) {
        int max = 0;
        for (int k = i; k < j; k++) {
            if (A[k] > max)
                max = A[k];
        }
        return max;
    }

}
