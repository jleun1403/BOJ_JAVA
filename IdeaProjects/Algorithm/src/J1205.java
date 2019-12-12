import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J1205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        boolean check[] = new boolean[1000001];
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int zero = 0;
        while (st.hasMoreElements()) {
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) zero += 1;
            else if (!check[a]) {
                check[a] = true;
                list.add(a);
            }
        }
        Collections.sort(list);
        int arr[] = new int[list.size()];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arr[cnt++] = list.poll();
        }
        int mark[] = new int[list.size()];
        int cur = 0;
        int answer = 0;
        int count = 0;
        int last = 0;
        int left = zero;
        if(left == size) answer= left;
        else if(size == 1) answer = left+1;
        else{
            for(int i=0; i<size; i++){ // 시작 지점.
                count = 1;
                left = zero;
                last =0;
                for(int j=i+1; j<size; j++){
                    if(j == size-1){
                        if(j!=0 && (arr[j] == last+1) || arr[j]==arr[j-1]+1) count+=1;
                        answer= Math.max(answer, count+left);
                        break;
                    }
                    else if(j!=0 && (arr[j] == arr[j-1]+1 || arr[j] == last+1)){
                        count+=1;
                    }
                    else {
                        if(j!=0 && arr[j]-arr[j-1]-1 <=left){
                            left-=arr[j]-arr[j-1]-1;
                            count+=arr[j]-arr[j-1];
                            last = arr[j];
                        }
                        else{ // 커버안되는 경우
                            if(j!=0 && (arr[j]==arr[j-1]+1 || arr[j]==last+1)) count+=1;
                            count+=left;
                            answer= Math.max(answer, count);
                            break;
                        }
                    }
                }
//                System.out.println("i="+ i + " "+ answer);

            }
            answer = Math.max(answer,count+left);
        }

        System.out.println(answer);

    }
}
/*
7
0 6 5 10 3 0 11
6
100 100 100 99 97 103
8
0 0 0 1 2 6 8 1000
5
0 1 0 2 0
 */