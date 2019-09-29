import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class number3 {
    static class Time{
        int start, end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Time arr[] = new Time[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Time(a,b);
        }
        int answer=0;
        for(int t =0; t<=150; t++){
            int count =0;
            for(int i=0; i<n; i++){
                if(arr[i].start <=t && arr[i].end >t){
                    count+=1;
                }
            }
            answer = Math.max(answer,count);
        }
        System.out.println(answer);
    }
}
