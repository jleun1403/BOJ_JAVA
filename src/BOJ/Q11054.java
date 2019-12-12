import java.util.Scanner;

public class Q11054 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] input = new int[ n + 1];
        int[] order = new int[ n + 1];
        int[] reverse = new int[ n + 1];
        int[] result = new int[n+1];
        for (int i = 1 ; i <= n ; i++)
            input[i] = scanner.nextInt();
        order[1] = 1;
        reverse[n] = 1;
        for (int i = 2 ; i <= n ; i++) {
            int length = 0;
            for (int j = 1 ; j < i ; j++) {
                if (input[j] < input[i])
                    if (order[j] > length)
                        length = order[j];
            }
            order[i] = length + 1;
        }
        for (int i = n-1 ; i >= 1 ; i--) {
            int length = 0;
            for (int j = n ; j > i ; j--) {
                if (input[j] < input[i])
                    if (reverse[j] > length)
                        length = reverse[j];
            }
            reverse[i] = length + 1;
        }
        int bitonicmax = 0;
        for (int i = 1; i <= n ; i++) {
            result[i] = order[i] + reverse[i] - 1;
            if (result[i] > bitonicmax)
                bitonicmax = result[i];
        }
        System.out.println(bitonicmax);

    }
}
