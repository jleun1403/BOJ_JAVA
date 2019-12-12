import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int answer = -1;
        int d[] = new int[m + 1];
        if (start + arr[0] <= m)
            d[start + arr[0]] = 1;
        if (start - arr[0] >= 0)
            d[start - arr[0]] = 1;
        for (int i = 1; i < n; i++) {
            int temp[] = new int[m + 1];
            for (int j = 0; j <= m; j++) {
                if (d[j] == 1) {
                    if (j + arr[i] <= m) {
                        temp[j + arr[i]] = 1;
                    }
                    if (j - arr[i] >= 0) {
                        temp[j - arr[i]] = 1;
                    }
                }
            }
            Arrays.fill(d, 0);
            for (int k = 0; k <= m; k++) {
                if (temp[k] == 1)
                    d[k] = 1;

            }

        }
        for(int i=0; i<=m; i++) {
            if(d[i]==1 ) answer= Math.max(answer, i);
        }
        System.out.println(answer);
    }

}
