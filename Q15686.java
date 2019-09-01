import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q15686 {
    static int n, m, arr[][], result[], answer;
    static Position chicken[];
    static class Position{
        int x, y;
        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int solve(){
        int sum=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 1){
                    int min=101;
                    int d= 0;
                    for(int k=0; k<m; k++){
                        Position p = chicken[result[k]];
                        d = Math.abs(p.x-i) + Math.abs(p.y-j);
                        if(d <min) {
                            min = d;
                        }
                    }
                    sum+= min;
                }
            }
        }
        return sum;
    }
    public static void go(int index, int visited){
        if(index == m) {
            answer = Math.min(answer,solve());
            return;
        }
        for(int i=0; i<chicken.length; i++){
            if((visited & (1<<i))==0){
                if(index==0 || (index!=0 && result[index-1] <i)){
                    result[index] = i;
                    go(index+1, visited | (1<<i));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr= new int[n][n];
        result = new int[m];
        answer=Integer.MAX_VALUE;
        LinkedList<Position> list= new LinkedList<>();
        for(int i=0; i<n; i++){
            int cnt =0;
            st= new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                int a=Integer.parseInt(st.nextToken());
                arr[i][cnt] = a;
                if(arr[i][cnt]==2) list.add(new Position(i,cnt));
                cnt++;
            }
        }
        chicken = new Position[list.size()];
        for(int i=0; i<chicken.length; i++){
            chicken[i] = list.poll();
        }
        go(0, 0);
        System.out.println(answer);

    }
}
