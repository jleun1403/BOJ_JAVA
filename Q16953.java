import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q16953 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        PriorityQueue<Long> q = new PriorityQueue<Long>();
        q.add(a);
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(a, 1);
        boolean flag = false;
        while (!q.isEmpty()) {
            Long cur = q.poll();
            //System.out.println(cur+" "+ map.get(cur));
            if(cur == b) {
                flag= true;
                break;
            }
            if (cur > b) {
                break;
            }
            if (!map.containsKey(cur * 2)) {
                q.add(cur * 2);
                map.put(cur * 2, map.get(cur) + 1);
            }

            if (!map.containsKey(cur * 10 + 1)) {
                q.add(cur * 10 + 1);
                map.put(cur * 10 + 1, map.get(cur) + 1);
            }

        }
        if (flag == true) {
            System.out.println(map.get(b));
        } else {
            System.out.println("-1");
        }
    }

}
