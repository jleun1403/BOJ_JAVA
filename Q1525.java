import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Q1525 {
    static int arr[][], answer;

    static HashSet<String> set;

    static class Puzzle {
        String s;
        int cnt;
        int zero;

        public Puzzle(String s, int zero, int cnt) {
            this.s = s;
            this.zero = zero;
            this.cnt = cnt;
        }
    }

    public static String swap(String s, int x, int y) {
        StringBuilder sb = new StringBuilder();
        char st[] = s.toCharArray();
        char temp = st[x];
        st[x] = st[y];
        st[y] = temp;
        for (int i = 0; i < st.length; i++) {
            sb.append(st[i] - '0');
        }
        return sb.toString();
    }

    public static void go(String ss, int cur, int count) {
        Queue<Puzzle> q = new LinkedList<Puzzle>();
        q.add(new Puzzle(ss, cur, count));
        while (!q.isEmpty()) {
            Puzzle p = q.poll();
            int curr = p.zero;
            int cnt = p.cnt;
            if (p.s.equals("123456780")) {
                answer = p.cnt;
                break;
            }
            String t = "";
            switch (curr) {
                case 0:
                    t = swap(p.s, curr, 1);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 1, cnt + 1));
                    }
                    t = swap(p.s, curr, 3);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 3, cnt + 1));
                    }
                    break;
                case 1:
                    t = swap(p.s, curr, 0);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 0, cnt + 1));
                    }
                    t = swap(p.s, curr, 2);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 2, cnt + 1));
                    }
                    t = swap(p.s, curr, 4);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 4, cnt + 1));
                    }
                    break;
                case 2:
                    t = swap(p.s, curr, 1);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 1, cnt + 1));
                    }
                    t = swap(p.s, curr, 5);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 5, cnt + 1));
                    }
                    break;
                case 3:
                    t = swap(p.s, curr, 0);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 0, cnt + 1));
                    }
                    t = swap(p.s, curr, 4);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 4, cnt + 1));
                    }
                    t = swap(p.s, curr, 6);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 6, cnt + 1));
                    }
                    break;
                case 4:
                    t = swap(p.s, curr, 1);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 1, cnt + 1));
                    }
                    t = swap(p.s, curr, 3);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 3, cnt + 1));
                    }
                    t = swap(p.s, curr, 5);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 5, cnt + 1));
                    }
                    t = swap(p.s, curr, 7);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 7, cnt + 1));
                    }

                    break;
                case 5:
                    t = swap(p.s, curr, 2);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 2, cnt + 1));
                    }
                    t = swap(p.s, curr, 4);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 4, cnt + 1));
                    }
                    t = swap(p.s, curr, 8);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 8, cnt + 1));
                    }
                    break;
                case 6:
                    t = swap(p.s, curr, 3);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 3, cnt + 1));
                    }
                    t = swap(p.s, curr, 7);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 7, cnt + 1));
                    }
                    break;
                case 7:
                    t = swap(p.s, curr, 4);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 4, cnt + 1));
                    }
                    t = swap(p.s, curr, 6);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 6, cnt + 1));
                    }
                    t = swap(p.s, curr, 8);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 8, cnt + 1));
                    }
                    break;
                case 8:
                    t = swap(p.s, curr, 5);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 5, cnt + 1));
                    }
                    t = swap(p.s, curr, 7);
                    if (!set.contains(t)) {
                        set.add(t);
                        q.add(new Puzzle(t, 7, cnt + 1));
                    }
                    break;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        answer = 0;
        int zero = 0;
        for (int i = 0; i < 3; i++) {
            String temp[] = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                s += temp[j];
                if (temp[j].equals("0"))
                    zero = i * 3 + j;
            }
        }
        set = new HashSet<>();
        if (s.equals("123456780"))
            System.out.println("0");
        else {
            go(s, zero, 0);
            if (!set.contains("123456780"))
                answer = -1;
            System.out.println(answer);
        }
    }
}