import java.util.Scanner;

public class Q1267 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int arr[] = new int[n];
        int answer1=0, answer2=0;
        for(int i=0; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<n; i++){
            answer1 += (arr[i]/30 +1) *10;
            answer2 += (arr[i]/60 +1) * 15;
        }
        if(answer1 == answer2) System.out.println("Y M "+answer1);
        else if(answer1 < answer2) System.out.println("Y "+ answer1);
        else System.out.println("M "+ answer2);
    }
}
