import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q15685 {
    static int dx[] = { 0, -1, 0, 1 }, dy[] = { 1, 0, -1, 0 };

    static class Position {
        int x, y, d, z;

        public Position(int x, int y, int d, int z) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.z = z;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Position> list = new ArrayList<>();
        int answer = 0;
        int arr[][] = new int[101][101];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            arr[x][y] = i+1;
            list.add(new Position(x, y, d, z));
        }
        for (int k = 0; k < n; k++) {
            ArrayList<Integer> dir = new ArrayList<>();
            Position p = list.get(k);
            int x = p.x + dx[p.d];
            int y = p.y + dy[p.d];
            dir.add(p.d);
            arr[x][y] = k+1;
            for (int i = 1; i <= p.z; i++) {
                for (int j = (int) (Math.pow(2, i-1))-1; j >= 0; j--) {
                    int curd = dir.get(j);
                    curd += 1;
                    if (curd == 4) curd =0;
                    dir.add(curd);
                    x+= dx[curd];
                    y+= dy[curd];
                    arr[x][y] = k+1;
                }
            }
        }
        for(int i=0; i<=99; i++) {
            for(int j=0; j<=99; j++) {
//				System.out.printf(arr[i][j]+" ");
                if(arr[i][j]!=0 && arr[i][j+1]!=0 && arr[i+1][j]!=0 && arr[i+1][j+1] !=0) answer+=1;
            }
        }
        System.out.println(answer);
    }

}
