import java.util.*;
import java.io.*;

public class Q7576 {
    static int dx[] = { -1, 1, 0, 0 };
    static int dy[] = { 0, 0, -1, 1 };
    static int arr[][];
    static boolean check[][];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first[] = br.readLine().split(" ");
        int m = Integer.parseInt(first[0]);
        int n = Integer.parseInt(first[1]);
        arr = new int[n][m];
        check = new boolean[n][m];
        LinkedList<String> q = new LinkedList<String>();
        int answer = 0;
        StringTokenizer st;
        boolean ok = false;
        int maxnum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    q.add(i + " " + j);
                    check[i][j] = true;
                }
                j+=1;
            }
        }
        
        if (q.size() == 0) {
            answer = -1;
        } else {
            while (!q.isEmpty()) {
                int x = Integer.parseInt(q.getFirst().split(" ")[0]);
                int y = Integer.parseInt(q.getFirst().split(" ")[1]);
                q.pop();
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        if (arr[nx][ny] == 0) {
                            arr[nx][ny] = arr[x][y] + 1;
                            //check[nx][ny] = true;
                            q.add(nx + " " + ny);
                        }
                    }
                }
            }
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                if(arr[i][j] == 0){
                    ok= true;
                    break;
                }
                else {
                    if(maxnum < arr[i][j]) maxnum = arr[i][j];
                }
            }
            if(ok == true){
                break;
            }
        }
        answer= maxnum-1;
    }
        System.out.println(answer);
    }
}