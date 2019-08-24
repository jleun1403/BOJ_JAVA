import java.util.ArrayList;
import java.util.Scanner;

public class Q6064 {
    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static long solve(long a, long b) {

        return a * b / gcd(a, b);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tt = 0; tt < t; tt++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            long gc = solve(m, n);
            boolean flag = false;
            int cnt = 0;
            long answer = 0;
            ArrayList<Long> list = new ArrayList<>();
            if(m==x && n==y) {
                System.out.println(solve(m,n));
                continue;
            }
            while (true) {
                if (m * cnt + x > gc)
                    break;
                list.add((long) m * cnt + x);
                cnt += 1;
            }
            for (int i = 0; i < list.size(); i++) {
                long cur = list.get(i);
               // System.out.println(cur%n);
                if (cur % n == y) {
                    answer = cur;
                    flag = true;
                    break;
                }
                else if(n == y){
                    if(cur%n == 0){
                        answer = cur;
                        flag = true;
                        break;
                    }
                }
            }
            if (flag == false)
                System.out.println("-1");
            else
                System.out.println(answer);
        }
    }

}
