import java.util.Scanner;

public class Q2875 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int cur = Math.min(n/2,m);
        int sum = n+m - cur*3;
        if(sum<k) {
           int temp = k-sum;
           if(temp%3 ==0) cur-= temp/3;
           else cur-= temp/3 +1;
        }
        System.out.println(cur);

    }
}
