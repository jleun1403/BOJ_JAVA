import java.util.Scanner;

public class Q11722 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] D = new int[n+1];
        int[] Dnew = new int[n+1];

        for (int i = 1; i <= n; i++)
            D[i] = scanner.nextInt();
        Dnew[1] = 1;
        int tmin = Dnew[1];
        for (int i = 2 ; i <= n ; i++) {
            int length = 0;
            for (int j = 1 ; j < i ; j++) {
                if (D[j] > D[i]){
                    if (Dnew[j] > length)
                        length = Dnew[j];
                }
            }
            Dnew[i] = length + 1;
            if (Dnew[i] > tmin)
                tmin = Dnew[i];
        }
        System.out.println(tmin);

    }
}
