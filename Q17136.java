import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17136 {
    static int arr[][], answer;
    static int left[];
    static boolean check[][];
    public static boolean isok(int x, int y, int len){
        if(x+len >10 || y+len >10) return false;
        if( left[len] <=0) return false;
        for(int i=0; i<len; i++){
            for(int j=0 ;j<len; j++){
                if(arr[x+i][y+j] ==0) return false;
            }
        }
        return true;
    }
    public static void go(int x, int y, int cnt){
        if(x == 10 && y ==0) {
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    if(arr[i][j]==1) return;
                }
            }
            answer = Math.min(answer, cnt);
            return;
        }
        int nx = x;
        int ny = y+1;
        if(y == 9){
            nx = x+1;
            ny = 0;
        }
        if(arr[x][y] ==1) {
            for (int k = 5; k >= 1; k--) {
                if (isok(x, y, k)) {
                    left[k] -= 1;
                    for (int p = 0; p < k; p++) {
                        for (int q = 0; q < k; q++) {
                            arr[x+p][y+q] = 0;
                        }
                    }
                    go(nx,ny,cnt+1);
                    for (int p = 0; p < k; p++) {
                        for (int q = 0; q < k; q++) {
                            arr[x+p][y+q] = 1;
                        }
                    }
                    left[k]+=1;
                }
            }
        }
        else go(nx,ny,cnt);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[10][10];
        check = new boolean[10][10];
        left = new int [6];
        answer = Integer.MAX_VALUE;
        for(int i=1; i<=5; i++) left[i] = 5;
        for(int i=0 ; i<10; i++){
            int cnt =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()) {
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        go(0,0, 0);
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
}
