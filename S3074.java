
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3074 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Integer.parseInt(st.nextToken());
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);
            long answer = arr[n-1]*m;
            long left = 1, right = arr[n-1]*m;
            long count =0;
            long middle = 0;
            while (left < right) {
                count = 0;
                middle = (right-left) / 2 + left;
                for (int i = 0; i < n; i++) {
                    count += middle / arr[i];
                }

                if (count >= m) {
                    //System.out.println(middle);
                    answer = middle;
                    right = middle;

                } else {
                    left = middle + 1;
                }
            }
            System.out.println("#"+t+ " " +answer);
        }
    }

}
