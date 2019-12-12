import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J1828 {
    static class Tem implements Comparable<Tem>{
        int low, high;
        public Tem(int low, int high){
            this.low = low;
            this.high = high;
        }

        @Override
        public int compareTo(Tem o) {
            if(this.high == o.high){
                return this.low-o.low;
            }
            else return -(this.high-o.high);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Tem arr[] = new Tem[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new Tem(a,b);
        }
        boolean check[] = new boolean[n];
        int answer=0;
        Arrays.sort(arr);
        int curl = 0;
        int curh = 0;
        while(true) {
            boolean flag = false;
            for(int i=0; i<n; i++){
                if(!check[i]) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) break;
            for(int i=0; i<n; i++){
                if(!check[i]){
                    check[i] = true;
                    curl = arr[i].low;
                    curh = arr[i].high;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                if(!check[i] && arr[i].high>=curl && arr[i].high <=curh){
                    check[i] = true;
                    curh = arr[i].high;
                    if(arr[i].low >=curl) curl = arr[i].low;
                    //System.out.printf(i+" ");
                }
            }
//            System.out.println();
            answer+=1;
        }
        System.out.println(answer);
    }
}
/*

4
-15 5
-10 36
10 73
27 44



91
3 5
12 37
16 23
140 143
437 522
55 95
608 2898
4614 5026
5729 9521
0 0
0 6
4 25
-24 15
112 297
480 603
52 733
1712 2578
593 2453
695 769
0 0
-9 0
7 22
23 73
-161 113
152 454
193 778
827 2057
1287 7767
2439 2794
0 0
1 3
-42 10
18 39
230 269
86 339
210 817
2673 3451
3054 3717
4176 4969
0 0
-3 1
-43 37
52 54
76 202
258 553
51 647
2066 2387
3100 4254
2391 7004
0 0
0 2
-49 21
-73 58
161 217
423 651
316 682
345 2107
2454 6382
5106 9322
0 0
-9 7
48 49
-36 3
-122 110
635 710
220 292
2013 3319
4155 6749
2609 9557
0 0
3 7
2 12
-94 62
318 368
412 665
591 800
810 1967
3365 4434
3019 3715
0 0
2 3
14 26
49 54
329 364
174 370
766 878
68 2986
3920 6792
832 5078
0 0
-9 4

ans:18
 */
