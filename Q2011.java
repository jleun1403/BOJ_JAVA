import java.util.Arrays;
import java.util.Scanner;

public class Q2011 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] D = new int[s.length() + 1];
        D[0] = 1;
        if ((s.length() == 0)) {
            System.out.println(0);
            return;
        }
        if (s.equals("0")) {
            System.out.println(0);
            return;
        }
        D[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if ((s.charAt(i - 1) <= '6') && (s.charAt(i-1) >= '1')){
                if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2'))
                    D[i] = (D[i - 1] + D[i - 2]) % 1000000;
                else
                    D[i] = D[i - 1] % 1000000;
            }
            else if ((s.charAt(i - 1) <= '9') && (s.charAt(i-1) >= '7')) {
                if (s.charAt(i - 2) == '1')
                    D[i] = (D[i - 1] + D[i - 2]) % 1000000;
                else
                    D[i] = D[i - 1] % 1000000;
            }
            else if (s.charAt(i-1) == '0') {
                if ((s.charAt(i - 2) == '1') || (s.charAt(i - 2) == '2'))
                    D[i] = D[i - 2] % 1000000;
                else
                    D[i] = 0;
            }
            else {
                D[i] = D[i - 1] % 1000000;
            }
        }
        System.out.println(Arrays.toString(D));
        System.out.println(D[s.length()]);
    }
}
