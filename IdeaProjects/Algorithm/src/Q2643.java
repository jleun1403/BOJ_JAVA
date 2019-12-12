import java.util.Arrays;
import java.util.Scanner;

public class Q2643 {
    static class Position implements Comparable<Position>{
        int x, y;
        public Position(int x, int y) {
            this.x = x; this.y = y;
        }
        @Override
        public int compareTo(Position o) {
            if(this.y == o.y) return (this.x-o.x);
            else return (this.y-o.y);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Position arr[] = new Position[n];
        for(int i=0; i<n; i++) {
            int a= sc.nextInt();
            int b =sc.nextInt();
            arr[i] = new Position(Math.max(a, b),Math.min(a,b));
        }
        int answer = 0;
        Arrays.sort(arr);
//		int curx = arr[0].x; int cury =arr[0].y;
//		for(int i=1; i<n; i++) {
//			if(arr[i].x <=curx && arr[i].y <= cury) {
//				answer+=1;
//				curx = arr[i].x;
//				cury = arr[i].y;
//			}
//		}
//		for(int i=0; i<n; i++) {
//			System.out.println(arr[i].x + " " + arr[i].y);
//		}
        int d[] = new int[n];
        for(int i=0; i<n; i++) d[i] = 1;
        for(int i=1; i<n; i++) {
            int curx = arr[i].x;
            int cury = arr[i].y;
            for(int j=i-1; j>=0; j--) {
                if(curx >=arr[j].x && cury >=arr[j].y) {
                    if(d[i] <d[j]+1) {
                        d[i] = d[j]+1;
                    }
                }
                answer = Math.max(answer, d[i]);
            }
        }

        System.out.println(answer);
    }

}
