import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5557 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        long d[][] = new long[21][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cur = arr[0];
        int target = arr[n-1];
        // 0 ~ n-2 까지가 arr값.
        d[arr[0]][0] = 1;
        for(int i=1; i<n-1; i++) {
            for(int j=0; j<=20; j++) {
                if(d[j][i-1]!=0) {
                    //System.out.println(j);
                    if(j + arr[i] <=20) {
                        //System.out.println(d[j][i-1] + arr[i]);
                        d[j + arr[i]][i]+= d[j][i-1];
                    }
                    if(j - arr[i] >=0) {
                        d[j- arr[i]][i]+= d[j][i-1];
                    }
                }
            }

        }
        System.out.println(d[target][n-2]);
    }

}
