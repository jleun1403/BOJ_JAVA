import java.util.Scanner;

public class Q1629 {
    public static int c;
    public static long myPow(int a, int b){
        if (b==0) return 1;
        if(b==1) return a%c;
        if(b%2 ==0){
            long n = myPow(a,b/2);
            return (n*n ) %c;
        }
        else{
            return (a*myPow(a,b-1))%c;
        }
    }
    public static void main(String args[]){
        Scanner sc  = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        c= sc.nextInt();
        System.out.println(myPow(a,b));
    }

}
