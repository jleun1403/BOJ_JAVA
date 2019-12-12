import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q1941 {
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int answer;
    static int arr[][];
    static boolean visited[][];
    static int check[];
    static int result[];
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny =y + dy[i];
            if(nx>=0 && nx<5 && ny>=0 && ny<5){
                if(check[nx*5 + ny] ==1 && visited[nx][ny] == false){
                    dfs(nx,ny);
                }
            }
        }
    }
    public static void go(int cnt, int snum) {
        if (cnt == 7) {
            if(snum<4) return;
            //System.out.println(Arrays.toString(result));
            int count =0;
            visited = new boolean[5][5];
             for(int i=0; i<25;i++){
                 if(count>1) break;
                 if(check[i] == 1 && visited[i/5][i%5] == false){
                     count+=1;
                     dfs(i/5,i%5);
                 }

             }
             if(count==1) answer+=1;
            return;
        }
        for (int i = 0; i < 25; i++) {
            if (check[i] == 0) {
                if (cnt != 0){
                    if(result[cnt - 1] < i) {

                        check[i] = 1;
                        result[cnt] = i;
                        if(arr[i/5][i%5] == 'S') go(cnt+1, snum+1);
                        else go(cnt + 1,snum);
                        check[i] = 0;
                    }
                } else {
                    result[cnt] = i;
                    check[i] = 1;
                    if(arr[i/5][i%5] == 'S') go(cnt+1, snum+1);
                    else go(cnt + 1,snum);
                    check[i] = 0;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][5];
        visited = new boolean[5][5];
        check = new int[25];
        result = new int[7];
        //temp = new boolean[7];
        answer = 0;
        for (int i = 0; i < 5; i++) {
            String s[] = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        go(0,0);
        System.out.println(answer);
    }

}