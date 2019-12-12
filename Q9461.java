import java.util.Scanner;

public class Q9461 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();
        Long[] D = new Long[101];
        D[1] = D[2] = D[3] = 1L;
        D[4] = D[5] = 2L;
        D[6] = 3L;
        D[7] = 4L;
        D[8] = 5L;
        D[9] = 7L;
        D[10] = 9L;
        while(testcase-- >0) {
            int n = scanner.nextInt();
            for (int i = 11; i <= n; i++)
                D[i] = D[i - 1] + D[i - 5];
            System.out.println(D[n]);
        }
    }
}
