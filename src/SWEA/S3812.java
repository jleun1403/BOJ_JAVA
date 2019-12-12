import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S3812 {
    static int dist2[] = new int [1001];
    static int dist3[] = new int [1001];
    static long temp[] = new long [1001];
    static long answer[] = new long [1001];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {
            String ch[] = br.readLine().split(" ");
            int x = Integer.parseInt(ch[0]);
            int y = Integer.parseInt(ch[1]);
            int z = Integer.parseInt(ch[2]);
            int a = Integer.parseInt(ch[3]);
            int b = Integer.parseInt(ch[4]);
            int c = Integer.parseInt(ch[5]);
            int n = Integer.parseInt(ch[6]);
            dist2 = new int[n];
            dist3 = new int[n];
            answer= new long[n];
            temp = new long[n];
            for (int i = 0 ; i < n ; i++) {
                dist2[i] = dist3[i] = 0;
                answer[i] = temp[i] = 0;
            }
            for (int i = 0 ; i < x;  i++) {
                temp[Math.abs(i - a) % n] += 1;
            }
            for (int i = 0 ; i < y ; i++) {
                dist2[Math.abs(i - b) % n] += 1;
            }
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    answer[(i+j) % n ] += temp[i] * dist2[j];
                }
            }
            for (int i = 0 ; i < n ; i++) {
                temp[i] = answer[i];
                answer[i] = 0;
            }
            for (int i = 0 ; i < z ; i++) {
                dist3[Math.abs(i - c) % n] += 1;
            }
            for (int i = 0 ; i < n ; i++) {
                for (int j = 0 ; j < n ; j++) {
                    answer[(i+j) % n] += temp[i] * dist3[j];
                }
            }
            System.out.printf("#"+t+" ");
            for(int i = 0; i< n; i++) {
                System.out.printf(answer[i]+" ");
            }
            System.out.println();
        }

    }
}
