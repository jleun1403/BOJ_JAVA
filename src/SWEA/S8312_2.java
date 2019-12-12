
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S8312_2 {
    static int x,y,z, a, b, c, MOD, result[];
    static long arr[];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        for (int t = 1; t <= time; t++) {
            String ch[] = br.readLine().split(" ");
            x = Integer.parseInt(ch[0]);
            y = Integer.parseInt(ch[1]);
            z = Integer.parseInt(ch[2]);
            a = Integer.parseInt(ch[3]);
            b = Integer.parseInt(ch[4]);
            c = Integer.parseInt(ch[5]);
            MOD = Integer.parseInt(ch[6]);
            arr = new long[MOD];
            result = new int[3];
            long first= x%MOD==0?x/MOD+1:x/MOD;
            long second =y/MOD;
            long third = z/MOD;
            for(int i=0; i<MOD; i++) {
                for(int j=0; j<MOD; j++) {
                    for(int k=0; k<MOD; k++) {
                        arr[(Math.abs(i-a)+Math.abs(j-b)+Math.abs(k-c))%MOD]+=first * second * third;
                    }
                    for(int k=0; k<z%MOD;k++) {
                        arr[(Math.abs(i-a)+Math.abs(j-b)+Math.abs(k-c))%MOD]+= first * second ;
                    }
                }
                for (int j = 0; j < y % MOD; j++) {
                    for(int k=0; k<MOD; k++) {
                        arr[(Math.abs(i-a)+Math.abs(j-b)+Math.abs(k-c))%MOD]+= third * first;
                    }
                    for(int k=0; k<z%MOD;k++) {
                        arr[(Math.abs(i-a)+Math.abs(j-b)+Math.abs(k-c))%MOD]+=first ;
                    }
                }
            }
            for(int i=0; i<x % MOD; i++) {
                for (int j = 0; j < MOD; j++) {
                    for (int k = 0; k < MOD; k++) {
                        arr[(Math.abs(i - a) + Math.abs(j - b) + Math.abs(k - c)) % MOD] += second * third;
                    }
                    for (int k = 0; k < z % MOD; k++) {
                        arr[(Math.abs(i - a) + Math.abs(j - b) + Math.abs(k - c)) % MOD] += second;
                    }
                }
                for (int j = 0; j < y % MOD; j++) {
                    for (int k = 0; k < MOD; k++) {
                        arr[(Math.abs(i - a) + Math.abs(j - b) + Math.abs(k - c)) % MOD] += third;
                    }
                    for (int k = 0; k < z % MOD; k++) {
                        arr[(Math.abs(i - a) + Math.abs(j - b) + Math.abs(k - c)) % MOD] += 1;
                    }
                }
            }
            System.out.printf("#"+t+" ");
            for(int i=0; i<MOD; i++) {
                System.out.printf(arr[i]+" ");
            }
            System.out.println();
        }

    }
}