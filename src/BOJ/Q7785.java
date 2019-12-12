import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Q7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<n; i++){
            String temp[] = br.readLine().split(" ");
            if(!set.contains(temp[0])){
                set.add(temp[0]);
                list.add(temp[0]);
            }
            else{
                set.remove(temp[0]);
            }

        }
        Collections.sort(list);
        for(int i=list.size()-1; i>=0; i--){
            System.out.println(list.get(i));
        }
    }
}
