import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Q5430 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            Deque <Integer> deque = new LinkedList<Integer>();
            String operation = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String temp = br.readLine().replace("[","").replace("]", "");
            String temparr[] = temp.split(",");
            boolean flag = false;
            boolean check = false;
            for(int j=0; j<num; j++) {
                deque.add(Integer.parseInt(temparr[j]));
            }
            for(int j=0; j<operation.length(); j++) {
                char op = operation.charAt(j);
                if(op=='R') {
                    if(check== false) check= true;
                    else check = false;
                }
                else if(op =='D') {
                    if(check == false){ // at front
                        if(deque.isEmpty()) {
                            flag = true;
                            break;
                        }
                        deque.pollFirst();
                    }
                    else{ // at back
                        if(deque.isEmpty()){
                            flag = true;
                            break;
                        }
                        else deque.pollLast();
                    }

                }
            }
            if(flag == true) System.out.println("error");
            else {
                System.out.printf("[");
                int k = deque.size();
                if (!check) {
                    for (int j = 0; j < k; j++) {
                        if (j != k - 1) System.out.print(deque.pollFirst() + ",");
                        else System.out.print(deque.pollFirst());
                    }
                    System.out.printf("]\n");
                }
                else{
                    for(int j=k-1; j>=0; j--){
                        if(j!=0) System.out.print(deque.pollLast() + ",");
                        else System.out.print(deque.pollLast());
                    }
                    System.out.printf("]\n");
                }
            }
        }
    }

}
