import java.util.Scanner;

public class Q2163 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int answer = 0;
        answer= (m-1) + (m)*(n-1);
        System.out.println(answer);
    }

}
