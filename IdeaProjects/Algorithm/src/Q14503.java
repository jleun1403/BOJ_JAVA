import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {
    static int n, m, dx[] = {-1,0,1,0}, dy[]={0,1,0,-1},arr[][],answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int curx = Integer.parseInt(st.nextToken());
        int cury = Integer.parseInt(st.nextToken());
        int curd = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            if(arr[curx][cury] == 0){
                arr[curx][cury] = 2; // 청소 완료.
                answer+=1;
            }
            boolean flag = false;
            while(true) {
                for(int k=0; k<4; k++){
                    int nd = curd==0?3:curd-1;
                    if(arr[curx+dx[nd]][cury+dy[nd]]==0){
                        curd= nd;
                        curx+=dx[nd];
                        cury+=dy[nd];
                        flag = true;
                        break;
                    }
                    else{
                        curd= nd;
                    }
                }
                if(flag == true) break;
                int nx = curx-dx[curd];
                int ny= cury-dy[curd];
                if(arr[nx][ny] == 1){
                    System.out.println(answer);
                    System.exit(0);

                }
                else{
                    curx= nx;
                    cury = ny;
                }
            }
        }
    }
}
