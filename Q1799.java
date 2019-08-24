import java.util.Scanner;

public class Q1799 {
    static int n;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean check[];
    static int white[][];
    static int arr[][];
    static int max;
    static int num=1;
    public static boolean isok(int index){
        boolean flag = false;
        int x = index/n;
        int y = index%n;
        x-=1;
        y-=1;
        while(x>=0 && y>=0){
            if(!check[x*n +y]) {
                x -= 1;
                y -= 1;
                continue;
            }
            else {
                flag = true;
                break;
            }
        }
        if(flag == true) return false;
        x = index/ n;
        y = index % n;
        x-=1;
        y+=1;
        while(x>=0 && y<n){
            if(!check[x*n +y]) {
                x-=1;
                y+=1;
                continue;
            }
            else{
                flag = true;
                break;
            }
        }
        if(flag == true) return false;
        return true;
    }
    public static void go(int index, int cnt, int w){
        if(index/n == n){
            max = Math.max(max, cnt-1);
            return ;
        }
        for(int i=index; i<=n*n; i++){
            if(i==n*n) go(i,cnt+1,w);
            else{if(arr[i/n][i%n] == 1 && check[i] == false) {
                if (white[i / n][i % n]==w && isok(i)) {
                    check[i] = true;
                    go(i, cnt + 1,w);
                    check[i] = false;
                }
            }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        n = sc.nextInt();
        check = new boolean[n*n+1];
        white = new int[n+1][n+1];
        arr= new int[n+1][n+1];
        int answer=0;
        for(int i=0; i<n ; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        arr[n][0] = 1;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if((i%2==0 && j%2==0) || (i%2!=0 && j%2!=0)){
                    white[i][j]=1;
                }
            }
        }
        for(int k=0; k<2; k++) {
            check = new boolean[n * n + 1];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                    if (arr[i][j] == 1 && !check[i * n + j]) {
                        go(i * n + j, 0, k);
                    }
                }
            }
            answer+=max;
            max=0;
        }
        System.out.println(answer);
    }
}
