import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14499 {
    static int n, m, curx, cury, arr[][], dice[], dx[] = {0, 0, 0, -1, 1}, dy[] = {0, 1, -1, 0, 0};

    public static void go(int direction) {
        if (direction == 1) {
            int temp = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[3];
            dice[3] = dice[1];
            dice[1] = temp;
        } else if (direction == 2) {
            int temp = dice[1];
            dice[1] = dice[3];
            dice[3] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        } else if (direction == 3) {
            int temp = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[2];
            dice[2] = dice[1];
            dice[1] = temp;
        } else if (direction == 4) {
            int temp = dice[6];
            dice[6] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        curx = Integer.parseInt(st.nextToken());
        cury = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        dice = new int[7];
        int op[] = new int[k];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        while (st.hasMoreElements()) {
            op[cnt++] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < k; i++) {
            int opnum = op[i];
            int nx = curx + dx[opnum];
            int ny = cury + dy[opnum];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            else {
                // 주사위 굴리고
                go(opnum);
                System.out.println(dice[1]);
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = dice[6];
                } else {
                    dice[6] = arr[nx][ny];
                    arr[nx][ny] = 0;
                }
                curx = nx;
                cury = ny;
            }
        }

    }
}