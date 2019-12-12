import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16236 {
    static int n, arr[][], sharksize, curx, cury, d[][], dx[] = { -1, 1, 0, 0 }, dy[] = { 0, 0, -1, 1 };
    static class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void bfs(int x, int y) { //
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(x, y));
        d[x][y] = 1;
        int mind = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Position p = q.poll();
            int cx = p.x;
            int cy = p.y;
            for (int k = 0; k < 4; k++) {
                int nx = cx + dx[k];
                int ny = cy + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (d[nx][ny] ==0 && (arr[nx][ny] == 0 || arr[nx][ny] <= sharksize)) {
                        d[nx][ny] = d[cx][cy] + 1;
                        q.add(new Position(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr= new int[n][n];
        int eat = 0;
        sharksize = 2;
        int answer =0;
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            while(st.hasMoreElements()) {
                int a= Integer.parseInt(st.nextToken());
                arr[i][cnt]=a;
                if(a==9) {
                    curx = i; cury = cnt;
                    //arr[curx][cury] = 0;
                }
                cnt++;
            }
        }
        int number=0;
        while(true) {
            d = new int[n][n];
            bfs(curx, cury); //아기상어가 갈수 있는 루트.
            int mindist = Integer.MAX_VALUE;
            int minx = -1;
            int miny = -1;
            boolean found = false;
            for(int i= 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(d[i][j]!=0 && arr[i][j]!=0 && arr[i][j] < sharksize) { //먹을 수 있는 물고기.
                        found= true;// 먹을 수 있는 물고기 발견.
                        if(mindist > d[i][j]) {
                            mindist = d[i][j];
                            minx = i;
                            miny = j;
                        }
                    }
                }
            }
            if(found == false) break; // 먹을수 있는 물고기가 없으면 break.
            arr[curx][cury] = 0; // 상어가 있던 곳도 빈칸으로.
            arr[minx][miny] = 0; // 먹은칸은 빈칸으로.
            curx = minx;
            cury = miny;
            eat+=1;

            if(eat == sharksize) {
                eat = 0;
                sharksize+=1;
            }
            answer+= mindist-1;
        }
        System.out.println(answer);
    }

}

/*
 * 6
1 2 1 1 1 1
1 3 6 2 2 3
1 2 5 2 2 3
3 3 2 4 6 3
0 0 0 0 0 0
0 0 0 1 1 9
 */
