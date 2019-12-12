import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q1456 {
    static long baseLog(long x, long base) {
        return (long) (Math.log(x) / Math.log(base));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean prime[] = new boolean[10000001];
        long a = sc.nextLong();
        long b = sc.nextLong();
        prime[1] = true;
        int isPrime[] = new int[10000001];
        int answer = 0;
        int cnt = 0;
        // Arrays.fill(prime, true);
        for (long i = 2; i * i <= b; i++) {
            if (!prime[(int) i]) {
                for (long j = i * 2; j*j <= b; j += i) {
                    prime[(int) j] = true;
                }
                isPrime[cnt++] = (int) i;
            }
        }
        for(int i=0; i<cnt; i++){
            long n = isPrime[i];
            long temp = isPrime[i];
            while(isPrime[i] <= b/n){
                if(isPrime[i] * n >=a){
                    answer+=1;
                }
                n *= isPrime[i];
            }
        }
        System.out.println(answer);
    }
}
