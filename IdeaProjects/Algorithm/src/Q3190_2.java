import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q3190_2 {
    static int dx[] = { 0,1,0,-1}, dy[] = { 1,0,-1,0 };
    static class Dir {
        int time;
        String c;
        public Dir(int time, String c) {
            this.time = time;
            this.c = c;
        }
    }
    static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n + 1][n + 1];
        int applenum = Integer.parseInt(br.readLine());
        for (int i = 0; i < applenum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1; // 사과 위치 표시

        }
        ArrayList<Dir> dir = new ArrayList<>();
        ArrayList<Position> list = new ArrayList<>();
        int turn = Integer.parseInt(br.readLine());
        for (int i = 0; i < turn; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            String d = st.nextToken();
            dir.add(new Dir(t, d));
        }
        dir.add(new Dir(100000, "C"));
        list.add(new Position(1, 1));
        arr[1][1] = 2;
        int curd = 0;
        int curx = 1;
        int cury = 1;

        int answer = 0;

        for (int time = 0; time < dir.size(); turn++) {
            Dir t = dir.get(time);
            int tt = t.time;
            String dd = t.c;
            boolean flag = false;
            for(int i=0; i<tt; i++) {
                System.out.println(answer);
                curx += dx[curd];
                cury += dy[curd];
                System.out.println(curx+" "+cury);
                if (arr[curx][cury] == 1) { // 다음칸이 사과라면 사과가 없어지고 꼬리는 없어짐.
                    arr[curx][cury] = 2; // 사과 먹고
                    list.add(new Position(curx, cury));
                } else if (arr[curx][cury] == 2 || curx == n+1 || curx ==0 || cury == n+1 || cury==0) { // 몸이 닿은 경우.
                    flag = true;
                    break;
                } else { // 이동
                    list.add(new Position(curx,cury));
                    //arr[list.get(0).x][list.get(0).y]=0;
                    list.remove(0);
                }
                answer += 1;
            }
            if(flag == true) break;
            if(dd.equals("L")){
                curd-=1;
                if(curd==-1) curd = 3;
            }
            else if(dd.equals("D")) {
                curd+=1;
                if(curd==4) curd=0;
            }

        }
        System.out.println(answer);
    }

}