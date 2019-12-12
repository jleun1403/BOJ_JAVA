import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1456_2 {
    static long baseLog(long x, long base) {
        return (long) (Math.log(x) / Math.log(base));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean prime[] = new boolean[10000001];
        int twobase[] = new int [10000001];
        long a = sc.nextLong();
        long b = sc.nextLong();
        prime[1] = true;
        int isPrime[] = new int[10000001];
        int answer = 0;
        int cnt = 0;
        int twocnt =0;
        Arrays.fill(prime, true);

        for (int i = 2; i * i <= 10000000; i++) {
            if (prime[i] == true) {
                for (int j = i * i; j <= 10000000; j += i){
                    prime[j] = false;
                }
                isPrime[cnt++] = i;
            }
        }
       // System.out.println(Math.log(8)/Math.log(2));
        long temp1 =0;
        long temp2 =0;
//        String s = Integer.toBinaryString(a);
//      answer+=baseLog(b,2) - baseLog(a,2);
        for (int i = 0; i <cnt; i++) {
            long n =isPrime[i];
            if(n >b) break;
            temp1 = baseLog(b,n);
            temp2 = baseLog(a,n);
            if(temp1==0 || temp1 ==1) {
                break;
            }
            if(n >a) {
                temp2+=1;
            }
            answer+= temp1 - temp2 ;
        }
        if(Math.log(a) /Math.log(2) == (double) (Math.log(a)/ Math.log(2)))  answer+=1;
        System.out.println(answer);
    }
}
