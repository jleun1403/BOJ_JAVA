
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 09:20
public class S1861{
    static int n, arr[][], cnt, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1}, index;
    static boolean check[][];
    static class Position implements Comparable<Position>{
        int room, number;
        public Position(int room, int number) {
            this.room = room;
            this.number = number;
        }
        @Override
        public int compareTo(Position o) {
            if(this.number == o.number) {
                return this.room -o.room;
            }
            else return -(this.number - o.number);
        }
    }
    static void go(int x, int y, int c) {
//		check[x][y] = true;
        for(int k=0; k<4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<n) {
                if(arr[nx][ny]== arr[x][y] +1) {
                    go(nx, ny, c+1);
                }
            }
        }
        cnt = Math.max(cnt, c);
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cnt = 0;
                while (st.hasMoreElements()) {
                    arr[i][cnt++] = Integer.parseInt(st.nextToken());
                }
            }
            Position a [] = new Position[n*n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    cnt =0;
                    go(i,j,0);
                    a[i*n+j] = new Position(arr[i][j] , cnt);
                }
            }
            Arrays.sort(a);
            System.out.println("#"+t+" "+a[0].room +" "+(a[0].number+1));
        }

    }

}
