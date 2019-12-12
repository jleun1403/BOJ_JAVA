import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr [] = new int[n];
        int cnt = 0;
        long answer = 0;
        while(st.hasMoreElements()){
            arr[cnt++] = Integer.parseInt(st.nextToken());
        }
        String first [] = br.readLine().split(" ");
        int b = Integer.parseInt(first[0]);
        int c=  Integer.parseInt(first[1]);
        for(int i=0; i<n; i++){
            if(arr[i] <=b) answer+=1;
            else {
               int left = arr[i]-b;
               answer+= left/c +1;
               if(left%c !=0) answer+=1;
            }
        }
        System.out.println(answer);

    }
}
