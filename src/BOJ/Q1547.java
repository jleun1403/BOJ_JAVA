import java.util.Arrays;
import java.util.Scanner;

public class Q1547 {
    static int arr[], st[];
    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[4];
        st = new int[4];
        for(int i=1; i<=3; i++) {arr[i] = i; st[i] = i;}
        int m = sc.nextInt();
        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b= sc.nextInt();
            swap(a,b);
            //System.out.println(Arrays.toString(arr));
        }
        int answer= 0;
        for(int i=1; i<=3; i++) {
            if(arr[i] == 1) answer = i;
        }
        System.out.println(answer);
    }
}
