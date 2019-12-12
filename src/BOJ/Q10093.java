import java.util.Scanner;

public class Q10093 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long answer = 0;
        answer = Math.abs(m-n)-1;
        if(m==n) answer = 0;
        System.out.println(answer);
        if(n<=m) {
            for(long i=n+1; i<m; i++) {
                System.out.printf(i+" ");
            }
        }
        else {
            for(long i=m+1; i<n; i++) {
                System.out.printf(i+" ");
            }
        }
    }

}
