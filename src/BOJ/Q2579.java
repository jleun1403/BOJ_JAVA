import java.util.*;
import java.io.*;
public class Q2579{
    public static int max(int a, int b){
        if(a>=b) return a;
        else return b;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int arr[] = new int[n+1];
        int d[][] = new int[n+1][3];
        for(int i=1; i<=n; i++){
            arr[i] = sc.nextInt();
        }
        d[1][0]= 0;
        d[1][1] = arr[1];
        d[2][0] = arr[1];
        d[2][1] = arr[1] + arr[2];
        for(int i =3; i<=n; i++){
            d[i][1] = max(d[i-2][0] + arr[i-1], d[i-1][0]) + arr[i];
            d[i][0] = d[i-1][1];
        }
        //  for(int i=1; i<=n; i++){
        //      System.out.println(d[i][0] +" " + d[i][1]);
        //  }
        System.out.println(d[n][1]);
    }
}