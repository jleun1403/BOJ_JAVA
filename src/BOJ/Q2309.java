import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {
    static int arr[];
    static boolean check[];
    static int result[];
    static void go(int index, int sum){
        if(index == 7){
            if(sum ==100) {
                for(int i=0; i<7; i++) System.out.println(result[i]);
                System.exit(0);
            }
            return;
        }
        for(int i=0; i<9; i++){
            if(!check[i]){
                if(index==0 || (index>0 && result[index-1] <arr[i])){
                    check[i] = true;
                    result[index] = arr[i];
                    go(index+1, sum+arr[i]);
                    check[i] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr= new int[9];
        check = new boolean[9];
        result = new int [7];
        for(int i=0; i<9; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        go(0,0);
    }
}
