import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S8444 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int t= Integer.parseInt(br.readLine());
        for(int time =1; time<=t; time++) {
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n+1];
            int origin[] = new int[n+1];
            int cnt =1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()) {
                origin[cnt++] = Integer.parseInt(st.nextToken());
            }
            int answer=0;
            for(int i=1; i<=n; i++) {
                if(arr[i]==origin[i]) continue;
                else {
                    answer+=1;
                    for(int j=i; j<=n; j+=i) {
                        arr[j] = arr[j]==1?0:1;
                    }
                }
            }
            System.out.println("#"+time+" "+answer);
        }
    }

}