import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1937 {
    static int dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 }, n, arr[][];
    static long answer, d[][];

    static long go(int x, int y) {
        if (d[x][y] != 0)
            return d[x][y];
        long res = 1;
        long maxlen = 0;
        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                if (arr[x][y] < arr[nx][ny]) {
                    maxlen = Math.max(maxlen, go(nx, ny));
                }
            }
        }
        return d[x][y] = res + maxlen;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        d = new long[n][n];
        answer = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (d[i][j] == 0) {
                    answer = Math.max(answer, go(i, j));
                }
            }
        }
        System.out.println(answer);
    }

}
