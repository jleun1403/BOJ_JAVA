import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q16235 {
    static int dx[] = {-1,-1,-1,0,0,1,1,1}, dy[] = {-1,0,1,-1,1,-1,0,1};
    static class Position implements Comparable<Position>{
        int x, y, age,dead;
        public Position(int x, int y, int age, int dead){
            this.x = x; this.y = y; this.age = age; this.dead = dead;
        }

        @Override
        public int compareTo(Position o) {
            return this.age-o.age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());
        int energy[][] = new int[n+1][n+1];
//        LinkedList<Position> list = new LinkedList<>();
//        LinkedList<Position> die = new LinkedList<>();
        Position arr[] = new Position[m];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                energy[i][j] = 5;
            }
        }
        int food[][] = new int[n+1][n+1];
        for(int i=0; i<n; i++){
            int cnt =1;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreElements()){
                food[i+1][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            list.add(new Position(a,b,c,1));
            arr[i] = new Position(a,b,c,1);
        }
        int time = 0;

        while(true){
            // 봄
            Arrays.sort(arr);
            if(time == year) break;
            for(int i=0; i<arr.length; i++) {
                Position p = arr[i];
                int x = p.x;
                int y = p.y;
                int age = p.age;
                if (age <= energy[x][y]) {
                    energy[x][y] -= age;
                    p.age += 1;
                } else {
                    p.dead = 0;
                }
            }
            //여름
            for(int i=0; i<arr.length; i++){
                Position d = arr[i];
                if(arr[i].dead ==0) energy[d.x][d.y] += d.age/2;
            }
            //가을
            LinkedList<Position> newtree = new LinkedList<>();
            for(int i=0; i<arr.length; i++){
                Position p = arr[i];
                if(p.dead==0) continue;
                newtree.add(new Position(p.x,p.y,p.age,1));
                int x = p.x;
                int y = p.y;
                if(p.age%5==0){
                    for(int k=0; k<8; k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(nx>=1 && nx<=n && ny>=1 && ny<=n){
                            newtree.add(new Position(nx,ny,1,1));
                        }
                    }
                }
            }
            int size = newtree.size();
            arr= new Position[size];
            for(int i=0; i<size; i++){ // 새로 번식된 나무 추가하기.
                arr[i] = newtree.poll();
            }
            //겨울
            for(int i=1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    energy[i][j]+=food[i][j];
                }
            }
            time+=1;
        }
        System.out.println(arr.length);
    }
}
