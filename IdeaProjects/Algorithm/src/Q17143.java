import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17143 {
    static int dx[] = {0, -1, 1, 0, 0}, dy[] = {0, 0, 0, 1, -1};
    static class Shark{
        int x, y, s,d,size,dead;
        public Shark(int x, int y, int s, int d, int size, int dead){
            this.x = x; this.y = y; this.s = s; this.d = d; this.size= size; this.dead = dead;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Shark arr[]= new Shark[k+1];
        int a[][] = new int[n][m];
        int answer = 0;
        for(int i=1; i<=k; i++){
            st = new StringTokenizer(br.readLine());
            int r= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            int s= Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());
            int size= Integer.parseInt(st.nextToken());
            r-=1;
            c-=1;
            arr[i] = new Shark(r,c,s,d,size,0);
            a[r][c] = i;
        }
        for(int man=0; man<m; man++){
            for(int i=0; i<n; i++){
                if(a[i][man]!=0){
                    int min = a[i][man];
                    arr[min].dead = 1;
                    answer+=arr[min].size;
                    a[i][man] = 0;
//                    System.out.println(arr[min].size);
                    break;
                }

            }
            // 상어 이동.
            int temp[][] = new int[n][m];
            for(int i=1; i<=k; i++){
                if(arr[i].dead==1) continue;
                int x= arr[i].x;
                int y =arr[i].y;
                int d = arr[i].d;
                int s = arr[i].s;
                int nx, ny;
                while(true){
                    nx = x + s * dx[d];
                    ny = y + s * dy[d];
                    if(nx >=0 && nx <n && ny >=0 && ny <m) break;
                    if(d == 1 && nx <0)  {s-= x; x = 0; d = 2;}
                    else if (d ==2 && nx >= n) {s-= n-1-x; x = n-1; d =1;}
                    else if(d == 3 && ny >=m) {s-= m-1-y; y = m-1; d = 4;}
                    else if (d == 4 && ny <0)  {s-=y; y = 0; d = 3;}
                }
                if(temp[nx][ny] ==0) temp[nx][ny] = i;
                else {
                    if(arr[temp[nx][ny]].size < arr[i].size) {
                        arr[temp[nx][ny]].dead = 1;
                        temp[nx][ny] = i;
                    }
                    else{
                        arr[i].dead = 1;
                    }
            }
            arr[i].x = nx;
            arr[i].y = ny;
            arr[i].d = d;
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    a[i][j] = temp[i][j];
                }
            }
        }
        System.out.println(answer);
    }
}
