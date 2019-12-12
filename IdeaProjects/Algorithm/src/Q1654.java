import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1654 {

    public static void main(String[] args)  throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int arr[] = new int[k];
        int maxnum = 0;
        long answer = 0;
        for(int i=0; i<k; i++) {
            arr[i]= Integer.parseInt(br.readLine());
            maxnum = Math.max(maxnum, arr[i]);
        }
        long left = 1;
        long right= maxnum;
        long sum = 0;
        long mid = 0;
        while(left<=right) {
            mid = (left+right)/2;
            sum=0;
            for(int i=0; i<k; i++) {
                sum += arr[i]/mid;
            }
            if(sum >=n) {
                answer = Math.max(answer, mid);
                left= mid+1;
            }
            else right= mid-1;
        }
        System.out.println(answer);
    }
}
