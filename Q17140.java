import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17140 {
    public static int currow, curcol, arr[][];

    static class Position implements Comparable<Position> {
        int number, count;

        public Position(int number, int count) {
            this.number = number;
            this.count = count;
        }

        @Override
        public int compareTo(Position o) {
            if (this.count == o.count) {
                return this.number - o.number;
            } else
                return this.count - o.count;
        }
    }

    public static void print() {
        for (int i = 0; i < currow; i++) {
            for (int j = 0; j < curcol; j++) {
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void gorow() { // 행의 개수 >= 열의 개수
        int maxcol = -1;
        int copy[][] = new int[currow][curcol * 2]; // 일단 맥스로 설정
        for (int i = 0; i < currow; i++) {
            boolean check[] = new boolean[101];
            int temp[] = new int[101];
            int visited = 0;
            for (int j = 0; j < curcol; j++) {
                if (arr[i][j] == 0)
                    continue;
                if (!check[arr[i][j]]) {
                    check[arr[i][j]] = true;
                    visited += 1;
                }
                temp[arr[i][j]] += 1;
            }
            Position p[] = new Position[visited];
            int cnt = 0;
            for (int c = 1; c <= 100; c++) {
                if (temp[c] != 0) {
                    p[cnt] = new Position(c, temp[c]);
                    cnt++;
                }
            }
            Arrays.sort(p);
            int count = 0;
            for (int c = 0; c < cnt; c++) {
                copy[i][count++] = p[c].number;
                copy[i][count++] = p[c].count;
            }
            maxcol = Math.max(maxcol, count);
        }
        curcol = maxcol;
        arr = new int[currow][curcol];
        for (int i = 0; i < currow; i++) {
            for (int j = 0; j < curcol; j++) {
                arr[i][j] = copy[i][j];
            }
        }
//		print();

    }

    public static void gocol() { // 행의 개수 < 열의 개수
        int maxrow = -1;
        int copy[][] = new int[currow * 2][curcol]; // 일단 맥스로 설정
        for (int j = 0; j < curcol; j++) {
            boolean check[] = new boolean[101];
            int temp[] = new int[101];
            int visited = 0;
            for (int i = 0; i < currow; i++) {
                if (arr[i][j] == 0)
                    continue;
                if (!check[arr[i][j]]) {
                    check[arr[i][j]] = true;
                    visited += 1;
                }
                temp[arr[i][j]] += 1;
            }
            Position p[] = new Position[visited];
            int cnt = 0;
            for (int c = 1; c <= 100; c++) {
                if (temp[c] != 0) {
                    p[cnt] = new Position(c, temp[c]);
                    cnt++;
                }
            }
            Arrays.sort(p);
            int count = 0;
            for (int c = 0; c < cnt; c++) {
                copy[count++][j] = p[c].number;
                copy[count++][j] = p[c].count;
            }
            maxrow = Math.max(maxrow, count);
        }
        currow = maxrow;
        arr = new int[currow][curcol];
        for (int i = 0; i < currow; i++) {
            for (int j = 0; j < curcol; j++) {
                arr[i][j] = copy[i][j];
            }
        }
//		print();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        r -= 1;
        c -= 1;
        arr = new int[3][3];
        for (int i = 0; i < 3; i++) {
            int cnt = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreElements()) {
                arr[i][cnt++] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        currow = 3;
        curcol = 3;
        while (true) {
            if (currow-1 >= r && curcol-1 >= c) {
                if (arr[r][c] == k) {
                    break; // 정답 출력
                }
            }
            if (time > 100) {
                time = -1;
                break;
            }
            if (currow >= curcol) {
                gorow();
            } else {
                gocol();
            }

            time += 1;
        }
        System.out.println(time);
    }

}
