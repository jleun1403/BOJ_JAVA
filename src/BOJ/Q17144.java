import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17144 {
    static int n, m, arr[][], dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    public static void print(){
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                System.out.printf(arr[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void goup(int curx){
        int temp1 = arr[curx][m-1];
        int temp2 = arr[0][m-1];
        int temp3 = arr[0][0];
        for(int i=m-1; i>=2; i--){
            arr[curx][i] = arr[curx][i-1];
        }
        for(int i=0; i<=curx-2; i++){
            arr[i][m-1] = arr[i+1][m-1];
        }
        arr[curx-1][m-1] = temp1;
        for(int i=0; i<m-1; i++){
            arr[0][i] = arr[0][i+1];
        }
        arr[0][m-2] = temp2;
        for(int i=curx-1; i>=2; i--){
            arr[i][0] = arr[i-1][0];
        }
        arr[1][0] = temp3;
        arr[curx][1] = 0;
    }
    public static void godown(int curx){
        int temp1 = arr[curx][m-1];
        int temp2 = arr[n-1][m-1];
        int temp3 = arr[n-1][0];
        for(int i=m-1; i>=2; i--){
            arr[curx][i] = arr[curx][i-1];
        }
        for(int i=n-1; i>=curx+2; i--){
            arr[i][m-1] = arr[i-1][m-1];
        }
        arr[curx+1][m-1] = temp1;
//        print();
        for(int i=0; i<m-1; i++){
            arr[n-1][i] = arr[n-1][i+1];
        }
        arr[n-1][m-2] = temp2;
        for(int i=curx+1 ; i<=n-2; i++){
            arr[i][0] = arr[i+1][0];
        }
        arr[n-2][0] = temp3;
        arr[curx][1] = 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int curx = 0;
        arr= new int[n][m];
        for(int i=0; i<n ;i++){
            int cnt =0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                int a = Integer.parseInt(st.nextToken());
                arr[i][cnt] = a;
                if(a==-1) curx  = i;
                cnt++;
            }
        }
        int copy[][];
        for(int t=0; t<time ; t++) {
            copy = new int[n][m];
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(arr[i][j]>=5) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < m && arr[nx][ny] != -1) {
                                copy[nx][ny] += (arr[i][j] / 5);
                                cnt += 1;
                            }
                        }
                        copy[i][j] += arr[i][j] - ((arr[i][j] / 5) * cnt);
                    }
                    else copy[i][j] += arr[i][j];
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    arr[i][j] = copy[i][j];
                }
            }
            goup(curx - 1);
            godown(curx);
        }
        int sum =0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]>=1) sum+=arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
