import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1251 {
    static int parent[];
    static Position arr[];

    static class Position{
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Pos implements  Comparable<Pos>{
        int first,second;
        long cost;
        public Pos(int first, int second, long cost){
            this. first = first;
            this. second = second;
            this. cost = cost;
        }
        @Override
        public int compareTo(Pos o) {
            return Long.compare(this.cost,o.cost);
        }
    }
    public static int found(int x) {
        if (parent[x]<0)
            return x;
        else return parent[x] = found(parent[x]);
    }

    public static void union(int x, int y) {
        parent[x] = y;
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int time = 1; time <= t; time++) {
            int n = Integer.parseInt(br.readLine());
            arr = new Position[n];
            parent = new int[n];

            Arrays.fill(parent,-1);
            Position arr[] = new Position[n];
            Pos a[] = new Pos[n*n];
            for(int i=0; i<n; i++){
                arr[i] = new Position(0,0);
            }
            String[] tmpX = br.readLine().split(" ");
            String[] tmpY = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = new Position(Integer.parseInt(tmpX[i]), Integer.parseInt(tmpY[i]));
            }
            Double e = Double.parseDouble(br.readLine());
            int cnt =0;
            for(int i=0; i<n-1; i++){
                for(int j=i+1; j<n; j++){
                    a[cnt++] = new Pos(i,j, (long)(arr[i].x-arr[j].x)*(arr[i].x-arr[j].x)+(long)(arr[i].y-arr[j].y)*(arr[i].y-arr[j].y));
                }
            }
            Arrays.sort(a);

            double sum = 0;
            for(int i=0; i<cnt; i++){

                int p = a[i].first;
                int q = a[i].second;
                int fp  = found(p);
                int fq = found(q);
                if (fp != fq) {
                    parent[fq] = fp ;
                    sum += a[i].cost;
                }
            }
            sum *=e;
            System.out.println("#"+time+" "+Math.round(sum));

        }
    }

}