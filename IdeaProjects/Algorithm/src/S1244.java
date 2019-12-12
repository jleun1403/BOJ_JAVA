import java.util.Arrays;
import java.util.Scanner;

public class S1244 {
    static int m, len;
    static int arr[];
    static int answer;

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void go(int index, int cnt) {
        if (cnt == m) {
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum = sum * 10 + arr[i];
            }
            answer = Math.max(answer, sum);
            return;
        }
        for (int i = index; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] == arr[j]) {
                    go(i, cnt + 1);
                } else {
                   swap(i, j);
                    go(i, cnt + 1);
                    swap(j, i);
                }
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int time = sc.nextInt();
        for (int t = 1; t <= time; t++) {
            String n = sc.next();
            m = sc.nextInt();
            String s = String.valueOf(n);
            len = s.length();
            int cnt = 0;
            arr = new int[s.length()];
            answer = 0;
            for (int i = 0; i < s.length(); i++) {
                arr[cnt++] = s.charAt(i) - '0';

            }

            go(0, 0);
            System.out.printf("#%d %d\n", t, answer);
        }
    }

}