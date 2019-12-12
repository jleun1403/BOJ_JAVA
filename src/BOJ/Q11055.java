import java.util.Scanner;

public class Q11055 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int D[] = new int[n + 1];
        int Dnew[] = new int[n+1];
        for (int i = 1 ; i <= n ; i++)
            D[i] = scanner.nextInt();
        Dnew[1] = D[1];
        int tmax = 0;
        if (n == 1) {
            System.out.println(D[1]);
            return;
        }
        for (int i = 2 ; i <= n ; i++) {
            int max = 0;
            for (int j = 1 ; j < i ; j++) {
                if (D[j] < D[i]){
                    if ( Dnew[j] > max)
                        max = Dnew[j];
                }
            }
            Dnew[i] = max + D[i];
            if (Dnew[i] > tmax)
                tmax = Dnew[i];
        }
        System.out.println(tmax);
    }
}
