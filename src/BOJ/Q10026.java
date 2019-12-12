import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10026 {
    static char arr[][];
    static int n;
    static int dx[] = {-1, 1, 0,0};
    static int dy[] = {0,0,-1, 1};
    static boolean check[][];
    public static void go(int x ,int y, char c){
        check[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(arr[nx][ny] == c && check[nx][ny] == false){
                    go(nx,ny,c);
                }
            }
        }
    }
    public static void go2(int x ,int y){
        check[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n && check[nx][ny] == false){
                if(arr[nx][ny]!='B'){
                    go2(nx,ny);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr= new char[n][n];
        check = new boolean[n][n];
        for(int i=0; i<n; i ++){
            String temp = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = temp.charAt(j);
            }
        }
        int cnt =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(check[i][j] == false){
                    cnt+=1;
                    go(i,j,arr[i][j]);
                }

            }
        }
        System.out.printf(cnt+" ");
        check = new boolean[n][n];
        cnt =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] !='B' && !check[i][j]){
                    cnt+=1;
                    go2(i,j);
                }
            }
        }
        int cnt2 = 0;
        check = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] =='B' && !check[i][j]){
                    cnt2+=1;
                    go(i,j,'B');
                }
            }
        }
        System.out.println(cnt+cnt2);
    }
}
