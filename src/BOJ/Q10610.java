import java.util.Scanner;

public class Q10610 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int arr[] = new int[10];
        int sum =0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c =s.charAt(i);
            arr[c-'0']+=1;
            sum+=(c-'0');
        }
        if(arr[0] == 0 || sum%3!=0) System.out.println(-1);
        else{
            for(int i=9; i>=0; i--){
                for(int j=0; j<arr[i]; j++){
                    sb.append(i);
                }
            }
        }
        System.out.println(sb);

    }
}
