import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2573 {
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int arr[][], n, m;
    static boolean check[][];
    public static void go(int x, int y){
        check[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x  + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx <n && ny>=0 && ny<m){
                if(!check[nx][ny] && arr[nx][ny] >0){
                    go(nx,ny);
                }
            }
        }
    }
    public static boolean all(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 0) continue;
                else return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first[] = br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        m = Integer.parseInt(first[1]);
        arr= new int[n][m];
        check = new boolean[n][m];
        int zero [][] = new int [n][m];
        boolean flag = false;
        int answer = 0;
        for(int i=0; i<n; i++){
            String temp[] = br.readLine().split(" ");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int nx, ny, cnt =0, num=0, temp = 0;
        check = new boolean[n][m];
            while (true) {
                answer += 1;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (arr[i][j] != 0) {
                            cnt = 0;
                            for (int k = 0; k < 4; k++) {
                                nx = i + dx[k];
                                ny = j + dy[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] == 0) {
                                    cnt += 1;
                                }
                            }
                            zero[i][j] = cnt;
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        arr[i][j] -= zero[i][j];
                        if (arr[i][j] < 0) arr[i][j] = 0;
                    }
                }
                check = new boolean[n][m];
                temp = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (arr[i][j] != 0 && !check[i][j]) {
                            temp += 1;
                            go(i, j);
                        }
                    }
                }
                if (temp >= 2) {
                    break;
                } else if (all() && temp < 2) {
                    flag = true;
                    break;
                }
                num = temp;

            }
            if(flag  == true) answer = 0;
    System.out.println(answer);
    }
}
