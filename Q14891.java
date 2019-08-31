import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.StubNotFoundException;
import java.util.StringTokenizer;

public class Q14891 {
    public static int arr[][];
    public static void turn(int num, int dir){
        if(dir ==1) { // clockwise
            int temp =arr[num][7];
            for(int i=7; i>=1; i--){
                arr[num][i] = arr[num][i-1];
            }
            arr[num][0] = temp;
        }
        else{ // counter clockwise
            int temp = arr[num][0];
            for(int i=0; i<7; i++){
                arr[num][i] = arr[num][i+1];
            }
            arr[num][7] = temp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        arr = new int[5][8];
        for(int i=1; i<=4; i++){
            String temp [] = br.readLine().split("");
            for(int j=0; j<8; j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        int k = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i=0; i<k; i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n= Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());
            if(n==1){
                if(arr[1][2] != arr[2][6]) {
                    if(arr[2][2] != arr[3][6]) {
                        if(arr[3][2] != arr[4][6]){
                            turn(1,d);
                            turn(2,-d);
                            turn (3,d);
                            turn (4,-d);
                        }
                        else{
                            turn(1,d);
                            turn(2,-d);
                            turn (3,d);

                        }
                    }
                    else{
                        turn (1,d);
                        turn(2,-d);
                    }

                }
                else turn(1,d);
            }
            else if(n==2){
            if(arr[1][2] != arr[2][6])
                turn(1,-d);
                if(arr[2][2]!= arr[3][6]){
                    if(arr[3][2]!=arr[4][6]){
                        turn(2,d);
                        turn (3,-d);
                        turn(4,d);
                    }
                    else{
                        turn(2,d);
                        turn(3,-d);
                    }
                }
                else{
                    turn(2,d);
                }
            }
            else if(n==3){
                if(arr[3][2] != arr[4][6]) turn(4,-d);
                if(arr[3][6]!=arr[2][2]){
                    if(arr[2][6]!=arr[1][2]){
                        turn(3,d);
                        turn(2,-d);
                        turn(1,d);
                    }
                    else{
                        turn(3,d);
                        turn(2,-d);
                    }
                }
                else{
                    turn (3,d);
                }
            }
            else if(n==4){
                if(arr[3][2] !=arr[4][6]){
                    if(arr[2][2]!=arr[3][6]){
                        if(arr[1][2]!= arr[2][6]){
                            turn(4,d);
                            turn(3,-d);
                            turn(2,d);
                            turn(1,-d);
                        }
                        else{
                            turn(4,d);
                            turn(3,-d);
                            turn(2,d);
                        }
                    }
                    else{
                        turn(4,d);
                        turn(3,-d);
                    }
                }
                else turn(4,d);
            }
        }
        for(int t=1; t<=4; t++){
            if(arr[t][0] == 1) answer+=Math.pow(2,t-1);
        }
        System.out.println(answer);
    }
}
