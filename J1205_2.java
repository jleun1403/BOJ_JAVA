import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class J1205_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt =0;
        boolean check[] = new boolean[1001];
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int zero = 0;
        while(st.hasMoreElements()){
            int a = Integer.parseInt(st.nextToken());
            if(a==0) zero+=1;
            else if(!check[a]){
                check[a] = true;
                list.add(a);
            }
        }
        Collections.sort(list);
        int size = list.size();
        int arr[] = new int[size];
        int joker[] = new int[size];
        for(int i=0; i<size;i++){
            arr[cnt++] = list.poll();
        }

        int max = -1;
        int length = 1;
        int curZ = zero;
        int i = 0, j = 1;
        while(j < size) {
            if(j == size-1){
                length += curZ;
                if (max < length)
                    max = length;
                break;
            }
            if (arr[j-1] == arr[j] - 1) {
                j++;
                length++;
            } else {
                if ((arr[j] - arr[j-1] - 1) <= curZ) {
                    joker[j] = arr[j] - arr[j-1];
                    curZ -= joker[j];
                } else {
                    joker[j] = curZ;
                    length += curZ;
                    if (max < length)
                        max = length;
                    length -= curZ;
                }
            }
            while(i<size && joker[i] == 0){
                i++;
                length--;
            }
            if(i!=size) {
                length -= joker[i];
                joker[i] = 0;
            }
            else{}

            if(i==j)
                j++;
        }

        System.out.println(max);
    }
}
/*
7
0 6 5 10 3 0 11
6
100 100 100 99 97 103
8
0 0 0 1 2 6 8 1000
 */
