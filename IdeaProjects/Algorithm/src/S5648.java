import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S5648 {
    static int dx[] = { 1, -1, 0, 0 }, dy[] = { 0, 0, -1, 1 };

    static class Position {
        int x, y, d, e;
        public Position(int x, int y, int d, int e) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.e = e;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {
            int answer = 0;
            int n = Integer.parseInt(br.readLine());
            LinkedList<Position> list = new LinkedList<>();
            LinkedList<Position> copy;
            int sum [][];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                x = (x + 1000) * 2;
                y = (y + 1000) * 2;
                list.add(new Position(y, x, d, e));
            }
            sum = new int[4001][4001];
            while (true) {
                int len = list.size();
                if(len == 0) break;
                for (int i = 0; i < len; i++) { // 원자 이동.
                    Position p = list.poll();
                    sum[p.x][p.y] = 0;
                    int nx = p.x + dx[p.d];
                    int ny = p.y + dy[p.d];
                    if (nx >= 0 && nx <= 4000 && ny >= 0 && ny <= 4000) {
                        p.x = nx;
                        p.y = ny;
                        sum[nx][ny] += p.e;
                    } else {
                        p.e = 0;
                    }
                    list.add(p);
                }

                copy = new LinkedList<>();
                for (int i = 0; i <len; i++) {
                    Position p = list.poll();
                    if(p.e ==0) continue;
                    if(sum[p.x][p.y]!=p.e) { // 충돌한곳
                        answer+=sum[p.x][p.y];
                        sum[p.x][p.y]=0;
                        p.e=0;
                    }
                    else copy.add(p);
                }
                list = (LinkedList<Position>)copy.clone();
                copy.clear();
            }
            System.out.printf("#%d %d\n", t, answer);
        }
    }

}