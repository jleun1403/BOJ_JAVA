import java.util.Scanner;

public class J2074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr [][] = new int [n+1][n+1];
        int num =1;

        int curx = 1;
        int cury = n/2 +1;
        arr[curx][cury] = num++;
        while(true){

            curx-=1;
            cury-=1;
            if(curx<1){
                curx = n;
            }
            else if(cury<1){
                cury = n;
            }
            arr[curx][cury] = num;
            if(num== n*n) break;
            if(num % n ==0){
                num+=1;
                curx+=1;
                arr[curx][cury]= num;
       }
            num+=1;


        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                System.out.printf(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
