import java.util.Scanner;

public class Q16917 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        a = Math.min(a, 2*c);
        b = Math.min(b, 2*c);
        int answer =Integer.MAX_VALUE;
        for(int i=0; i<=Math.min(d, e);i++) {
            int nd = d;
            int ne = e;
            answer= Math.min(answer,  a*(nd-i)+b*(ne-i)+c*2*i);
        }
        System.out.println(answer);
    }

}
