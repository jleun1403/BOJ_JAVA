import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S7206 {
    static int answer;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {
            answer = 0;
            String num = br.readLine();
            int number = Integer.parseInt(num);
            if (number < 10) {
                answer = 0;
            } else {
                go(1, number, 0);
            }
            System.out.println("#" + t + " " + answer);
        }
    }
    private static void go(int before, int number, int cnt) { // number 만드는데 쪼갠 횟수가 cnt. 123, 0\
//		System.out.println("S: " + before + " " + number + " " + cnt);
        //if(before>=10) return;
        if (number < 10) {
            if (before * number <= 10) {
                answer = Math.max(answer, cnt);
            }
            return;
        }
        String num = Integer.toString(number);
        for (int i = 0; i < num.length() - 1; i++) { // i번 뒤로 쪼개기
            int firstnum = Integer.parseInt(num.substring(0, i + 1));
            int secondnum = Integer.parseInt(num.substring(i + 1));
            go(before * firstnum, secondnum, cnt);
            go(1,before*firstnum*secondnum,cnt+1);

        }
        answer = Math.max(answer, cnt);
    }
/*
4
3451
5674
2467
6849
8 11 7 14

5
12345
23456
34567
45678
56789
10 16 19 21 23
*/
}
