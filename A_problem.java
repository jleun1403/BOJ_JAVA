import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class A_Problem {
    public static int arr[], arr2[], n, answer;
    public static HashSet<String> set;

    static class Position {
        String s;
        int cnt;

        public Position(String s, int cnt) {
            this.s = s;
            this.cnt = cnt;
        }
    }

    public static int[] swap(int ar[], int a, int b) {
        int temp = ar[a];
        ar[a] = ar[b];
        ar[b] = temp;
        return ar;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int time = 1; time <= t; time++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            int copy[] = new int[n];
            set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = 0;
            answer = 0;
            StringBuilder temp = new StringBuilder();
            while (st.hasMoreElements()) {
                int a = Integer.parseInt(st.nextToken());
                temp.append(Integer.toString(a) + " ");
                arr[cnt] = a;
                cnt++;
            }
            String s = temp.toString();
            temp = new StringBuilder();
            for (int i = 1; i <= n; i++)
                temp.append(Integer.toString(i) + " ");
            String start = temp.toString();
            temp = new StringBuilder();
            for (int i = n; i >= 1; i--) {
                temp.append(Integer.toString(i) + " ");
            }
            String end = temp.toString();
            Queue<Position> q = new LinkedList<Position>();
            q.add(new Position(s, 0));
            set.add(s);

            while (!q.isEmpty()) {
                Position cur = q.poll();
                if (cur.cnt > 5) {
                    answer = -1;
                    break;
                }
                if (cur.s.equals(start) || cur.s.equals(end)) {
                    set.add(start);
                    set.add(end);
                    System.out.println(cur.s);
                    answer = cur.cnt;
                    break;
                }
                copy = new int[n];
                String m[] = cur.s.split(" ");
                for (int i = 0; i < n; i++) {
                    copy[i] = Integer.parseInt(m[i]);
                }
                for (int i = n / 2 - 1; i >= 1; i--) {
                    int ii = i;
                    for (int j = 0; j <n/2-i; j++) {
                        copy = swap(copy, ii, ii + 1);
                        ii += 2;
                    }

                    StringBuilder sb = new StringBuilder();

                    for (int j = 0; j < n; j++)
                        sb.append(Integer.toString(copy[j]) + " ");
                    if (!set.contains(sb.toString())) {
                        set.add(sb.toString());
                        q.add(new Position(sb.toString(), cur.cnt + 1));
                    }
                }
                copy = new int[n];
                String mm[] = cur.s.split(" ");
                for (int i = 0; i < n; i++) {
                    copy[i] = Integer.parseInt(mm[i]);
                }
                for (int i = 0; i < n / 2; i++) {
                    copy = swap(copy, i, i + n / 2);
                }
                String s2 = "";
                for (int i = 0; i < n; i++) {
                    s2 += Integer.toString(copy[i]);
                    s2 += " ";
                }
                if (!set.contains(s2)) {
                    set.add(s2);
                    q.add(new Position(s2, cur.cnt + 1));
                }
                for (int i = n / 2 - 1; i >= 1; i--) {
                    int ii = i;
                    for (int j = 0; j < (n / 2)-i; j++) {
                        copy = swap(copy, ii, ii + 1);
                        ii += 2;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n; j++)
                        sb.append(Integer.toString(copy[j]) + " ");
                    if (!set.contains(sb.toString())) {
                        set.add(sb.toString());
                        q.add(new Position(sb.toString(), cur.cnt + 1));
                    }
                }
            }

            if (!set.contains(start) || !set.contains(end))
                answer = -1;
            System.out.println("#" + time + " " + answer);
        }
    }

}
 