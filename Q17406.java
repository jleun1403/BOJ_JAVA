import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q17406 {
    static int arr[][], turn[][], copy[][];
    static boolean check[];
    static int result[] ;
    static int n, m,k,answer;
    public static void round(int startx, int starty, int len){
        int temp1 = copy[startx][starty+len];
        int temp2 = copy[startx+len][starty+len];
        int temp3 = copy[startx+len][starty];
        for(int i=len; i>0; i--){
            copy[startx][starty+i] = copy[startx][starty+i-1];
        }
        for(int i=len; i>1; i--){
            copy[startx+i][starty+len] = copy[startx+i-1][starty+len];
        }
        copy[startx+1][starty+len] = temp1;
        for(int i=0; i<len-1; i++){
            copy[startx+len][starty+i] = copy[startx+len][starty+i+1];
        }
        copy[startx+len][starty+len-1] = temp2;
        for(int i=0; i<len-1; i++){
            copy[startx+i][starty] = copy[startx+i+1][starty];
        }
        copy[startx+len-1][starty] = temp3;
    }
    public static void solve(int r, int c, int s){
        for(int i=1; i<=s; i++){
            round(r-i,c-i,i*2);
        }
    }
    public static void go(int index){
        if(index == k) {
            int temp = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    copy[i][j] = arr[i][j];
                }
            }
            for(int i=0; i<k; i++){
//                System.out.println(turn[result[i]][0] +" " + turn[result[i]][1]+ " "+turn[result[i]][2]);
                solve(turn[result[i]][0]-1, turn[result[i]][1]-1,turn[result[i]][2]);
            }
//            for(int i=0; i<n; i++){
//                for(int j=0; j<m; j++){
//                    System.out.print(copy[i][j] +" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            for(int i=0; i<n; i++){
                int sum =0;
                for(int j=0; j<m; j++){
                    sum+=copy[i][j];
                }
                answer = Math.min(answer,sum);
            }
            return;
        }
        for(int i=0; i<k; i++){
            if(!check[i]){
                check[i] = true;
                result[index] = i;
                go(index+1);
                check[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first[] = br.readLine().split(" ");
        n= Integer.parseInt(first[0]);
        m= Integer.parseInt(first[1]);
        k= Integer.parseInt(first[2]);
        arr= new int [n][m];
        copy = new int[n][m];
        turn= new int[6][3];
        check = new boolean[6];
        result = new int[6];
        answer = 987654321;
        for(int i=0; i<n; i++){
            int cnt =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<k; i++){
            int cnt =0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                turn[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
       go(0);
        System.out.println(answer);
    }
    /*
    5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
3 4 2
4 2 1
     */
}
