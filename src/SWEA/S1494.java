import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1494 {
    static int n, m[][];
    static Position arr[], result[];
    static boolean check[], temp[];
    static int vector [];
    static long minimum;
    static class Position{
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void go(int index, int cnt,int visited) {
        if(cnt ==n/2) {
            long sumx = 0, sumy = 0;
            for(int i=0; i<n; i++) {
                if((visited & (1<<i)) ==0) {
                    sumx+= arr[i].x;
                    sumy+=arr[i].y;
                }
                else {
                    sumx-= arr[i].x;
                    sumy -= arr[i].y;
                }
            }
            long sum = sumx*sumx + sumy*sumy;
            if(sum < minimum) {
                minimum = sum;
            }
            return;
        }
        for(int i= index; i<n; i++) {
            if((visited & (1<<i)) ==0) {
                go(i+1,cnt+1,visited | (1<<i));
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for(int t=1; t<=time; t++) {
            n = Integer.parseInt(br.readLine());
            arr= new Position[n];
            result= new Position[n];
            m = new int[n][n];
            int a, b;
            for(int i=0; i<n; i++) {
                StringTokenizer st= new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                arr[i] = new Position(a,b);

            }
            minimum = Long.MAX_VALUE;
            check = new boolean[n];
            go(0,0,0);
            System.out.println("#"+t+" " +minimum);
        }
    }

}
