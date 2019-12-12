import java.util.Scanner;

public class Q1912 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] D = new int[n+1];
        int[] Max = new int[n+1];
        int max_right;
        int max_left;
        for (int i = 1 ; i <= n ; i++)
            D[i] = scanner.nextInt();
        int max = D[1];
        for (int i = 1; i <= n ; i++) {
            int temp_right = D[i];
            int temp_left = D[i];
            max_right =  max_left = D[i];
            for (int j = i + 1 ; j <= n ; j++) {
                temp_right = temp_right + D[j];
                if (temp_right > max_right)
                    max_right = temp_right;
            }
            for (int j = i -1 ; j >= 1 ; j--) {
                temp_left = temp_left + D[j];
                if (temp_left > max_left)
                    max_left = temp_left;
            }
            Max[i] = max_right + max_left - D[i];
            if (Max[i] > max)
                max = Max[i];

        }
        System.out.println(max);
    }
}
