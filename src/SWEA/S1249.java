import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1249 {
    static int n, arr[][], d[][], dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            d = new int[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                    d[i][j] = Integer.MAX_VALUE;
                }
            }
            d[0][0] = 0;
            Queue<Position> q = new LinkedList<>();
            q.add(new Position(0, 0));
            while (!q.isEmpty()) {
                Position p = q.poll();
                int curx = p.x;
                int cury = p.y;
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < 4; i++) {
                    int nx = curx + dx[i];
                    int ny = cury + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (d[curx][cury] + arr[nx][ny] < d[nx][ny]) {
                            d[nx][ny] = d[curx][cury] + arr[nx][ny];
                            q.add(new Position(nx, ny));
                        }
                    }

                }
            }
            System.out.println("#"+t+" "+d[n - 1][n - 1]);
        }
    }

}
