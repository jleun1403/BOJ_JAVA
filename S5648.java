import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S5648 {
    static int dx[] = { 1, -1, 0, 0 }, dy[] = { 0, 0, -1, 1 }, sum[][];

    static class Position {
        int x, y, d, e;
        public Position(int x, int y, int d, int e) {
            super();
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
            int max = 0;
            int n = Integer.parseInt(br.readLine());
            LinkedList<Position> list = new LinkedList<>();
            Position arr [] = new Position[n];
            int total = n;
            sum = new int[4001][4001];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                x = (x + 1000) * 2;
                y = (y + 1000) * 2;
                max = Math.max(max, x);
                max = Math.max(max, y);
                list.add(new Position(y, x, d, e));
//                arr[i] = new Position(y,x,d,e);
            }
            while (!list.isEmpty()) {
                boolean check[][] = new boolean[max + 1][max + 1];
                for (int i = 0; i < list.size(); i++) { // 원자 이동.
                    Position p = arr[i];
                    sum[p.x][p.y] = 0;
                    int nx = p.x + dx[p.d];
                    int ny = p.y + dy[p.d];
                    if (nx >= 0 && nx <= max && ny >= 0 && ny <= max) {
                        sum[nx][ny] += p.e;
                        p.x = nx;
                        p.y = ny;

                    } else {
                        p.e = 0;
                    }
                }

                for (int i = 0; i < len; i++) {
                    Position p = arr[i];
                    if(p.e ==0) continue;
                    if(sum[p.x][p.y]!=p.e) {
                        answer+=sum[p.x][p.y];
                        sum[p.x][p.y]=0;
                        p.e = 0;
                    }

                }
                LinkedList<Position> copy = new LinkedList<>();
                for(int i=0; i<len; i++){
                    if(arr[i].e!=0) copy.add(arr[i]);
                }

                arr = new Position[copy.size()];
                for(int i=0; i<copy.size(); i++){
                    arr[i] = copy.poll();
                }

            }
            System.out.printf("#%d %d\n", t, answer);
        }
    }

}