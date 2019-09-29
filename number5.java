import java.util.Arrays;
import java.util.Scanner;

public class number5 {
    static long d[][];
    static long go(int x, int y){
        if(x==1) return 1;
        if(y == 0 || y == x) return 1;
        if(d[x][y] !=-1) return d[x][y];
        else{
            return d[x][y] = (go(x-1,y-1)+go(x-1, y));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x<0 || x>a || y<0 || y>b) {
            System.out.println("fail");
            return;
        }
        d= new long[49][49];
        for(int i=0; i<49; i++) {
            Arrays.fill(d[i], -1);
        }
        System.out.println(x+y);
        System.out.println(go(x+y,x));
    }
}
