import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {
    static int n, m, arr[][], dx[] = { -1, 0, 1, 0 }, dy[] = { 0, 1, 0, -1 }, curx, cury, curd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        curx = Integer.parseInt(st.nextToken());
        cury = Integer.parseInt(st.nextToken());
        curd = Integer.parseInt(st.nextToken());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        while (true) {
            if (arr[curx][cury] == 0) { // 1번 현재 위치 청소하기.
                arr[curx][cury] = 2; // 청소완료
                answer += 1;
            }
            int count = 0;
            boolean flag = false;
            while(true){
                for (int k = 0; k < 4; k++) {
                    int nd = curd == 0 ? 3 : curd - 1; //
                    if (arr[curx + dx[nd]][cury + dy[nd]] == 0) { // 2번 시작.
                        curd = nd;
                        curx += dx[nd];
                        cury += dy[nd];
                        flag = true;
                        break; // 다시 1번부터 진행.
                    } else { // arr[][] == 1 || ==2 : 청소가 되어있거나 벽이거나.
                        curd = nd;
                    }
                }
                if(flag == true) break;
                int nx = curx - dx[curd];
                int ny = cury - dy[curd];
                if (arr[nx][ny] == 1) { // 후진해도 벽인 경우.
                    System.out.println(answer);
                    System.exit(0);
                } else {
                    curx = nx;
                    cury = ny;
                }
            }
        }

    }

}