import java.util.Scanner;

public class Q1463 {
    public static void main(String[] args) {
        int D[] = new int[1000001];
        D[2] = D[3] = 1;
        D[1] = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 4; i <= 1000001; i++) {
            if (i % 6 == 0)
                D[i] = Math.min(D[i - 1], Math.min(D[i / 3], D[i / 2])) + 1;
            else if (i % 3 == 0)
                D[i] = Math.min(D[i / 3], D[i - 1]) + 1;
            else if (i % 2 == 0)
                D[i] = Math.min(D[i / 2], D[i - 1]) + 1;
            else
                D[i] = D[i - 1] + 1;

        }
        System.out.println(D[n]);

    }
}
