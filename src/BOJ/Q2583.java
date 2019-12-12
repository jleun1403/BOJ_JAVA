import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q2583  {
    static ArrayList<Integer> list;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int n, m;
    static int arr[][];
    static boolean check[][];
    static int num;
    public static void go(int x, int y){
        check[x][y] = true;
        arr[x][y] = 2;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y+ dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if(arr[nx][ny] == 0 && check[nx][ny] == false){
                    num+=1;
                    go(nx,ny);
                }
            }
        }
        //num = Math.max(num,count);
    }
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first[] = br.readLine().split(" ");
        n = Integer.parseInt(first[0]);
        m = Integer.parseInt(first[1]);
        int k = Integer.parseInt(first[2]);
        arr= new int[n][m];
        check = new boolean[n][m];
        list = new ArrayList<>();
        for(int t=0; t<k; t++) {
            String temp[] = br.readLine().split(" ");
            int y1 = Integer.parseInt(temp[0]);
            int x1 = Integer.parseInt(temp[1]);
            int y2 = Integer.parseInt(temp[2]) - 1;
            int x2 = Integer.parseInt(temp[3]) - 1;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    arr[x][y] = 1;
                }
            }
        }

            int cnt = 0;
            for(int i=0; i<n; i++){
                for(int j=0 ; j<m; j++){
                    if(arr[i][j] == 0 && check[i][j] == false){
                        cnt+=1;
                        num =1;
                        go(i,j);
                        list.add(num);
                    }
                }
            }
            System.out.println(cnt);
            Collections.sort(list);
            for(int a : list){
                System.out.printf(a+" ");

        }
    }

}
