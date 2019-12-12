import java.util.*;
import java.io.*;
public class Q10815 {
    
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n =Integer.parseInt(br.readLine());
        String temp[] = br.readLine().split(" ");   
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(temp[i]);
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(br.readLine());
        int find[] = new int[m];
        String s [] = br.readLine().split(" ");
        for(int i=0; i<m; i++){
            find[i] = Integer.parseInt(s[i]);
            if(Arrays.binarySearch(arr,find[i])>=0) bw.write("1 ");
            else bw.write("0 ");
        }
        bw.flush();
        bw.close(); 
    }
}