import java.util.Arrays;
import java.util.Scanner;

public class Swap {
    static int n ,m, arr[],result[];
    static boolean check[];
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void go(int index, int before) {
        if(index ==m) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for(int i=before; i<n; i++) {
            result[index]=arr[i];
            go(index+1, i+1);
        }
    }
    public static void solve(int index) {
        if(index == n) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for(int i=index; i<n; i++) {
            swap(index, i);
            solve(index+1);
            swap(index, i);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
//  m = sc.nextInt();
        check = new boolean[n];
        arr = new int[n];
        result = new int[m];
        for(int i=0; i<n; i++) {
            arr[i] = i+1;
        }
//  go(0,0);
        solve(0);
    }

}