import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17136 {
    static int n=10, arr[][], paper[], answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr= new int[n+1][n+1];
        paper = new int[6];
        for(int i=1; i<=5; i++) paper[i] = 5;
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer=Integer.MAX_VALUE;
        go(0,0,0);
        if(answer == Integer.MAX_VALUE)answer= -1;
        System.out.println(answer);

    }

    private static void go(int x, int y, int cnt) {

        if(cnt > answer) return;
        if(x==11 && y==1) {
            if(isall()){
                answer= Math.min(answer,cnt);
            }
            return;
        }
        int nx = x;
        int ny = y+1;
        if(ny==n+1){
            nx+=1;
            ny=1;
        }
        if(arr[x][y] == 0){
            go(nx,ny,cnt);
        }
        else{
            for(int k=5; k>=1; k--){
                if(isok(x,y,k)){
//                    System.out.println(x+" "+y+" "+k);
                    for(int i=0; i<k; i++){
                        for(int j=0; j<k; j++){
                            arr[x+i][y+j] = 0;
                        }
                    }
                    paper[k]-=1;
                    go(nx,ny,cnt+1);
                    paper[k]+=1;
                    for(int i=0; i<k; i++){
                        for(int j=0; j<k; j++){
                            arr[x+i][y+j]=1;
                        }
                    }
                }
            }
        }
    }

    private static boolean isall() {
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(arr[i][j] == 1) return false;
            }
        }
        return true;
    }

    private static boolean isok(int x, int y, int k) {
        if(paper[k]<1) return false;
        if(x+k-1>n || y+k-1>n ) return false;
        for(int i=0; i<k; i++){
            for(int j=0; j<k; j++){
                if(arr[x+i][y+j]!=1) return false;
            }
        }
        return true;
    }
}
