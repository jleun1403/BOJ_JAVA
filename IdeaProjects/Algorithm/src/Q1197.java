import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1197 {
    static int parent[], n;
    static class Position implements Comparable<Position>{
        int x,y, cost;
        public Position(int x, int y, int cost){
            this.x= x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Position o) {
            return this.cost- o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int answer=0;
        parent = new int[n+1];
        for(int i=1; i<=n; i++)parent[i] = i;
        ArrayList<Position> list = new ArrayList<>();
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            list.add(new Position(a,b,c));
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            Position p = list.get(i);
            int x = p.x;
            int y = p.y;
            int c =p.cost;
            int fx = find(x);
            int fy = find(y);
            if(fx!=fy){
                parent[fx]= fy;
                answer+=c;
            }
        }
        System.out.println(answer);
    }

    private static int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
