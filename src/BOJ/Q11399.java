import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        int arr[] = new int[n];
        for(int i=0; i<s.length; i++){
                arr[i] = Integer.parseInt(s[i]);
        }
        int answer = 0;
        int k = 0;
        Arrays.sort(arr);
        for(int i=0; i<arr.length; i++){
            k+=arr[i];
            answer+=k;
        }
        System.out.println(answer);
    }
}
