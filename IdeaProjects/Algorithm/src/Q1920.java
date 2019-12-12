import java.util.*;
import java.io.*;

public class Q1920{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int k = sc.nextInt();
            if(Arrays.binarySearch(arr,k)>=0) System.out.println(1);
            else System.out.println(0);
        }
    }
}
