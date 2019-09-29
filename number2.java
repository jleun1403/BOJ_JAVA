import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class number2 {
    static int size, arr[], m,count,result[];
    static String answer;

    static void go(int index, int visited){
        if(index == size ){

            count+=1;
            if(count== m){
                for(int i=0; i<size; i++){
                    answer+=Integer.toString(result[i]);
                }
            }
            return;
        }
        for(int i=0; i<size; i++){
            if((visited & (1<<i))==0){
                result[index] = arr[i];
                go(index+1,visited | (1<<i) );
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        while(st.hasMoreElements()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        m = Integer.parseInt(br.readLine());
        size = list.size();
        arr = new int [size];
        result= new int[size];
        for(int i=0; i<size; i++){
            arr[i] = list.get(i);
        }
        count = 0;
        answer = "";
        Arrays.sort(arr);

        go(0,0);
        System.out.println(answer);


    }
}
