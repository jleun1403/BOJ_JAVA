import java.util.*;
import java.io.*;
public class Q15649 {
    static int n, m;
    static int temp[];
    static boolean check[];
    public static void go(int cnt){
        if(cnt == m){
            for(int i=0; i<m; i++){
                System.out.printf(temp[i]+" ");
            }
            System.out.println();
            return;
        }
        for(int i=0; i<n; i++){
            if(check[i] == false){
                check[i] = true;
                temp[cnt] = i+1;
                go(cnt+1);
                check[i] = false;
            }
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int arr[] = new int[n];
        check = new boolean [n];
        temp = new int[m];
        for(int i=0; i<n; i++){
            arr[i] = i;
        }    
        go(0);
    }
}