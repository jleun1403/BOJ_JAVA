import java.util.Scanner;

public class Q9095 {
    public static void main(String[] args) {
        int D[] = new int[11];
        D[1] = 1;
        Scanner scanner = new Scanner(System.in);
        int testcase = scanner.nextInt();
        D[1] = 1;
        D[2] = 2;
        D[3] = 4;
        for (int i = 4 ; i <= 10 ; i++) {
            D[i] = D[i-1] + D[i-2] + D[i-3];
        }
        for (int i = 0 ; i < testcase ; i++) {
            int n = scanner.nextInt();
            System.out.println(D[n]);
        }
    }
}
