import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q16236 {
    static int dx[] = {-1, 0,0,1}, dy[] = {0,-1,1,0}, d[][], n, arr[][];
    static boolean check[][];
    public static void bfs(int x, int y){
        d[x][y] = 1;
        check[x][y] = true;
        for(int k=0; k<4; k++){
            int nx = x + dx[k];
            int ny = y = dy[k];
            if(nx>=0 && nx<n && ny>=0 && ny<n){

            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        arr= new int[n][n];
        int curx = 0, cury = 0;
        int size = 2;
        int fishnum =0;
        for(int i=0; i<n; i++){
            int cnt=0;
            StringTokenizer st= new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                int a= Integer.parseInt(st.nextToken());
                arr[i][cnt] = a;
                if(a==9){
                    curx = i;
                    cury = cnt;
                }
                else if(a>=1 && a<=6) fishnum+=1;
                cnt++;
            }
        }
        int eat= 0;
        boolean found = false;
        boolean cango = false;
        int time = 0;
        while(true){
            found = false;
            d= new int[n][n];
            check = new boolean[n][n];
            bfs(curx, cury);
            int min = 50;
            int mx = 0, my = 0;
            int cx= 0, cy = 0;
            if(fishnum==0) break;
            for(int k=0; k<4; k++) {
                int nx = curx + dx[k];
                int ny = cury + dy[k];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (arr[nx][ny] >= 1 && arr[nx][ny] <= arr[curx][cury]) { // 물고기가 있고 먹을 수 있으
                        found = true; // 먹을 수 있는 물고기 발견.
                        int d = Math.abs(nx - curx) + Math.abs(ny - cury);
                        if (d < min) {
                            mx = nx;
                            my = ny;
                            min = d;
                        }
                    }
                }
            }
            System.out.println("time = " + time+ " "+found +" " + cango);
            if(found == true){
                arr[curx][cury] = 0;
                curx = mx;
                cury = my;
                arr[curx][cury] = size;
                eat+=1;
                fishnum-=1;
            }
            if(eat == size){
                size+=1;
                eat=0;
            }
            time+=1;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    System.out.printf(arr[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(curx+" "+cury);
        }
        System.out.println(time);
    }

}
