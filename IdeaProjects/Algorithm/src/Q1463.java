import java.util.*;
import java.io.*;
public class Q1463{
    public static int min (int a, int b){
        if(a <=b) return a;
        else return b;
    }
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int d[] = new int [n+1];
        Arrays.fill(d,100000);
        final int MAX = 1000000;
        d[1] = 1;
        for(int i=2; i<=n; i++){
            d[i] = d[i-1]+1;
            if(i%2 ==0) d[i] = min(d[i],d[i/2] +1);
            if(i%3 ==0) d[i] = min(d[i], d[i/3]+1);
        }
        System.out.println(d[n]-1);
    }
}