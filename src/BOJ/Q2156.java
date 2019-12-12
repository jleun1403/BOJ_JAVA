import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2156 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int d[][] = new int[n + 1][2]; // 연속해서 마신 잔의 갯수
        d[1][0] = 0;
        d[1][1] = arr[1];
        if (n == 1) {
            System.out.println(arr[1]);
        } else {
            d[2][0] = arr[1];

            d[2][1] = arr[1] + arr[2];
            for (int i = 3; i <= n; i++) {
                d[i][1] = Math.max(d[i - 2][0] + arr[i - 1], d[i - 1][0]) + arr[i];
                d[i][0] = Math.max(d[i - 1][1], d[i - 1][0]);
            }
//        for(int i=1; i<=n; i++) {
//        	System.out.println(d[i][1]+" "+ d[i][0]);
//        }
            System.out.println(Math.max(d[n][1], d[n][0]));
        }

    }

}
