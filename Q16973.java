import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1:45
public class Q16973 {
    static int n, m, arr[][], dx[] = { 1, -1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        int answer = 0;
        int d[][] = new int[n + 1][m + 1]; // 최소거리.
        for (int i = 1; i <= n; i++) {
            int cnt = 1;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken()); // 직사각형의 크기
        int w = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken()); // 시작
        int sy = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken()); // 도착
        int Y = Integer.parseInt(st.nextToken());
        Position p[];
        boolean check[][] = new boolean[n + 1][m + 1];
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(sx, sy));
        d[sx][sy] = 1;
        check[sx][sy] = true;
        while (!q.isEmpty()) {
            Position pos = q.poll();
            int x = pos.x;
            int y = pos.y;
            for (int i = 0; i < 4; i++) { // 방향
                int tempx = x + dx[i];
                int tempy = y + dy[i];

                boolean ok = false;
                if (tempx >= 1 && tempx <= n && tempy >= 1 && tempy <= m && !check[tempx][tempy]) {
                    if (i == 0) { // 아래로
                        ok = false;
                        if (x + h <= n) {
                            for (int t = 0; t < w; t++) {
                                if (arr[tempx + h-1][y+t] == 1) {
                                    ok = true;
                                    break;
                                }
                            }
                            if (ok == false) {
                                d[tempx][tempy] = d[x][y] + 1;
                                check[tempx][tempy] = true;
                                q.add(new Position(tempx, tempy));
                            }
                        }
                    } else if (i == 1) { // 위로
                        ok = false;
                        if (x - 1 >= 1) {
                            for (int t = 0; t < w; t++) {
                                if (arr[tempx][y + t] == 1) {
                                    ok = true;
                                    break;
                                }
                            }
                            if (ok == false) {
                                d[tempx][tempy] = d[x][y] + 1;
                                check[tempx][tempy] = true;
                                q.add(new Position(tempx, tempy));
                            }
                        }
                    }
                    if (i == 2) { // 왼쪽
                        ok = false;
                        if (y - 1 >= 1) {
                            for (int t = 0; t < h; t++) {
                                if (arr[x + t][tempy] == 1) {
                                    ok = true;
                                    break;
                                }
                            }
                            if (ok == false) {
                                d[tempx][tempy] = d[x][y] + 1;
                                check[tempx][tempy] = true;
                                q.add(new Position(tempx, tempy));
                            }
                        }
                    }
                    if (i == 3) { // 오른쪽
                        ok = false;
                        if (tempy+w-1 <= m) {
                            for (int t = 0; t < h; t++) {
                                if (arr[x + t][tempy+w-1] == 1) {
                                    ok = true;
                                    break;
                                }
                            }
                            if (ok == false) {
                                d[tempx][tempy] = d[x][y] + 1;
                                check[tempx][tempy] = true;
                                q.add(new Position(tempx, tempy));
                            }
                        }
                    }

                }
            }
        }

        if (check[X][Y])
            answer = d[X][Y] - 1;
        else
            answer = -1;
        System.out.println(answer);

    }

}
