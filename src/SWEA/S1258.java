import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1258 {
    static int n, arr[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    static boolean check[][];
    static class Position implements Comparable<Position>{
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y  = y;
        }
        @Override
        public int compareTo(Position o) {
            if(this.x*this.y == o.x * o.y) return this.x - o.x;
            else return (this.x*this.y)-( o.x * o.y);
        }
    }
    static Position dfs(int x, int y) {
        Position p = new Position(0,0);
        int depthx = 1, depthy =1 ;
        int curx = x, cury = y;
        check[x][y] = true;
        while(arr[x][cury+1] !=0 && cury+1<n) {
            cury+=1;
            depthy+=1;
            check[x][cury] = true;
        }
        while(arr[curx+1][y]!=0 && curx+1<n) {
            curx+=1;
            depthx+=1;
            for(int j=y ; j<=cury; j++) {
                check[curx][j] = true;
            }
        }
        p.x = depthx;
        p.y = depthy;
        return p;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for(int t=1 ;t<=time; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            Position temp[] = new Position[10001];
            int count=0;
            for(int i=0; i<n; i++) {
                int cnt =0;
                StringTokenizer st = new StringTokenizer(br.readLine());
                while(st.hasMoreElements()) {
                    arr[i][cnt++]= Integer.parseInt(st.nextToken());
                }
            }
            check = new boolean[n][n];
            int num = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(arr[i][j] !=0 && !check[i][j]) {
                        count+=1;
                        temp[num++] = dfs(i,j);
                    }
                }
            }
//			for(int i=0; i<num; i++) {
//				System.out.println(temp[i].x + " " + temp[i].y);
//			}
            Position parr[] = new Position[num];
            for(int i=0; i<num; i++) {
                parr[i] = temp[i];
            }
            Arrays.sort(parr);
            System.out.printf("#"+t+" ");
            System.out.printf(count+" ");
            for(int i=0; i<num; i++) {
                System.out.printf(parr[i].x +" "+parr[i].y+" ");
            }
            System.out.println();

        }
    }

}
