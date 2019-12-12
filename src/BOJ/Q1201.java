import java.util.ArrayList;
import java.util.Scanner;

public class Q1201 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        if(m+k -1 <=n && n <=m*k){
            int a [] = new int[n];
            for(int i=0; i<n; i++){
                a[i] = i+1;
            }
            ArrayList<Integer> group = new ArrayList<Integer>();
            group.add(0);
            group.add(k);
            n-= k;
            m-=1;
            int groupsize = m==0? 1:n/m;
            for(int i=0; i<groupsize; i++){

            }
        }
        else{
            System.out.println("-1");
        }
    }
}
