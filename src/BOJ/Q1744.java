import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int one =0;
        int minus =0, plus =0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(arr[i]>=2) plus+=1;
            else if (arr[i] == 1) one+=1;
            else minus+=1;
        }
        int answer = 0;
        Arrays.sort(arr);
        if(minus>=0){
            for(int i=0; i<minus/2; i++){
                answer+= arr[2*i] * arr[2*i+1];
            }
            if(minus%2==1) answer+= arr[minus-1];
        }
        if(plus>=0){
            for(int i=0; i<plus/2; i++){
                answer+=arr[n-1-2*i] * arr[n-2-2*i];
            }
            if(plus%2==1) answer+=arr[n-plus];
        }
        answer+=one;
        System.out.println(answer);
    }
}
