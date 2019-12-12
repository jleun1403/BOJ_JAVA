import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J1108 {
    static class Position{
        int x, y;
        public Position(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int k =Integer.parseInt(br.readLine());
        LinkedList<Position> list = new LinkedList<>();
        int n =0;
        for(int i=1; i<=k; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            list.add(new Position(a,b));
            n = Math.max(n,Math.max(a, b));
        }
        ArrayList<Integer> arr[] = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            arr[i] = new ArrayList<>();
        }
        int size = list.size();
        for(int i=0; i<size; i++) {
            Position p = list.poll();
            arr[p.x].add(p.y);
        }
        int answer=0;
        for(int i=1; i<=n; i++) {
            Queue<Integer> q = new LinkedList<Integer>();
            int d[] = new int[n+1];
            d[i] = 1;
            q.add(i);
            while(!q.isEmpty()) {
                int cur = q.poll();
                for(int j=0; j<arr[cur].size(); j++) {
                    int next= arr[cur].get(j);
                    if(d[next] ==0) {
                        d[next] = d[cur]+1;
                        q.add(next);
                    }
                }
            }
            for(int j=1; j<=n; j++) {
                if(j!=i) {
                    answer+=d[j]-1;
                }
            }
        }
        double b = (double)(answer)/(double)(n)/(double)(n-1);
        System.out.println(String.format("%.3f", b));

    }

}