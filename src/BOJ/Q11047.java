import java.util.Scanner;

public class Q11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer = 0;
        int arr[] = new int[n];
        for(int i=0 ; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int index = n-1;
        while(k>0){
            if(k>=arr[index]){
                answer+=k/arr[index];
                k= k-(k/arr[index]) * arr[index];
            }
            else index--;
        }
        System.out.println(answer);
    }
}
