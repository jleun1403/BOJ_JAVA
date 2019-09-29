import java.util.Arrays;
import java.util.Scanner;

public class number1 {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }
            int ans[] = new int[m];
            for(int i=0; i<n; i++){
                Arrays.sort(ans);
                ans[0]+=arr[i];
            }
            Arrays.sort(ans);
            System.out.println(ans[m-1]);


    }
}
