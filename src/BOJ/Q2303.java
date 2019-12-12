import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2303 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[];
        int cnt=0;
        int maxnum =0;
        int result[] = new int[n];
        for(int t=0; t<n; t++) {
            arr= new int[5];
            cnt=0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()) {
                arr[cnt++] = Integer.parseInt(st.nextToken());
            }
            int max = 0;
            for(int i=0; i<3; i++) {
                for(int j=i+1; j<4; j++) {
                    for(int k=j+1; k<5; k++) {
                        max = Math.max(max, (arr[i]+arr[j]+arr[k])%10);
                    }
                }
            }
            result[t] = max;
            maxnum = Math.max(maxnum, max);
        }

        for(int t = n-1; t>=0; t--) {
            if(result[t] == maxnum) {
                System.out.println(t+1);
                break;
            }
        }
    }

}
