import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q3109 {
    static int n, m, arr[][], cnt, dx[] = { -1, 0, 1 }, dy[] = { 1, 1, 1 }, answer;
    static boolean check[][];

    public static boolean go(int x, int y) {

        if (y == m - 1) {
            return true;
        }
        check[x][y] = true;
        for (int k = 0; k < 3; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                if (!check[nx][ny] && arr[nx][ny] != 1) {
                    if (go(nx, ny))
                        return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String s[] = br.readLine().split("");
            for (int j = 0; j < m; j++) {

                if (s[j].equals(".")) {
                    arr[i][j] = 0; // 빈칸이면 0
                } else
                    arr[i][j] = 1; // 벽이면 1
            }
        }
        for (int i = 0; i < n; i++) {
            if (go(i, 0) == true)
                answer += 1;
        }
        System.out.println(answer);
    }

}
