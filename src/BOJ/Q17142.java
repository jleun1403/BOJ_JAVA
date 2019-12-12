import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q17142 {
    static int n, m, arr[][],copy[][],result[], answer,d[][],dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1},size;
    static Position pos[];
    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean isall() {
        boolean flag = false;
        first:
        for(int i=0; i<n; i++) {
            for(int j=0 ; j<n; j++) {
                if(arr[i][j] ==0 && d[i][j] == -1) {
                    flag = true;
                    break first;
                }
            }
        }
        if(flag == true) return false;
        else return true;
    }
    public static void go(int index, int before) {
        if(index ==m) {
            solve();
            return;
        }
        for(int i=before; i<size; i++) {
            result[index] = i;
            go(index+1, i+1);
        }
    }
    public static void solve() {
        d= new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++){
                d[i][j] = -1;
            }
        }
        Queue<Position> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            int px = pos[result[i]].x;
            int py = pos[result[i]].y;
            d[px][py] = 0;
            q.add(new Position(px,py));
        }
        while(!q.isEmpty()) {
            if(isall()) {
                int temp = 0;
                for(int i=0; i<n; i++) {
                    for(int j=0; j<n; j++) {
                        temp = Math.max(temp, d[i][j]);
                    }
                }
                answer= Math.min(answer, temp);
            }
            Position p = q.poll();
            int x = p.x;
            int y = p.y;
            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny= y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<n) {
                    if(d[nx][ny] ==-1 && arr[nx][ny] !=1) {
                        d[nx][ny] = d[x][y] +1;
                        q.add(new Position(nx,ny));
                    }

                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        LinkedList<Position> list = new LinkedList<>();
        arr= new int[n][n];
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                int a = Integer.parseInt(st.nextToken());
                arr[i][cnt] = a;
                if(a == 2) {
                    list.add(new Position(i,cnt));
                }
                cnt++;
            }
        }
        result = new int[m];
        size = list.size();
        pos= new Position[list.size()];
        for(int i=0; i<pos.length; i++) {
            pos[i] = list.poll();
        }
        answer= Integer.MAX_VALUE;
        go(0,0);
        if(answer == Integer.MAX_VALUE) answer= -1;
        System.out.println(answer);

    }

}
