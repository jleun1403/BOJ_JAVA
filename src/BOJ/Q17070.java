import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17070 {
    static int n, arr[][], answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         n = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        answer=0;
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        arr[1][1] = 1;
        arr[1][2] = 1;
        go(1,2,1);
        System.out.println(answer);
    }

    private static void go(int x, int y, int how) {
        if(x ==n && y==n ){
            answer+=1;
            return;
        }
        if(how==1){ // 가로로 온 경우
            if(y+1 <=n && arr[x][y+1]==0) {
                arr[x][y+1] = 1;
                go(x,y+1,1);
                arr[x][y+1]=0;
            }
            if(y+1<=n && x+1<=n && arr[x][y+1]==0&&arr[x+1][y]==0&&arr[x+1][y+1]==0){
                arr[x][y+1]=1;
                arr[x+1][y]=1;
                arr[x+1][y+1] = 1;
                go(x+1,y+1,3);
                arr[x][y+1]=0;
                arr[x+1][y]=0;
                arr[x+1][y+1] = 0;
            }
        }
        else if(how==2){
            if(x+1<=n && arr[x+1][y]==0){
                arr[x+1][y] = 1;
                go(x+1,y,2);
                arr[x+1][y]=0;
            }
            if(y+1<=n && x+1<=n && arr[x][y+1]==0&&arr[x+1][y]==0&&arr[x+1][y+1]==0){
                arr[x][y+1]=1;
                arr[x+1][y]=1;
                arr[x+1][y+1] = 1;
                go(x+1,y+1,3);
                arr[x][y+1]=0;
                arr[x+1][y]=0;
                arr[x+1][y+1] = 0;
            }
        }
        else if(how==3){
            if(y+1 <=n && arr[x][y+1]==0) {
                arr[x][y+1] = 1;
                go(x,y+1,1);
                arr[x][y+1]=0;
            }
            if(x+1<=n && arr[x+1][y]==0){
                arr[x+1][y] = 1;
                go(x+1,y,2);
                arr[x+1][y]=0;
            }
            if(y+1<=n && x+1<=n && arr[x][y+1]==0&&arr[x+1][y]==0&&arr[x+1][y+1]==0){
                arr[x][y+1]=1;
                arr[x+1][y]=1;
                arr[x+1][y+1] = 1;
                go(x+1,y+1,3);
                arr[x][y+1]=0;
                arr[x+1][y]=0;
                arr[x+1][y+1] = 0;
            }
        }
    }
}
