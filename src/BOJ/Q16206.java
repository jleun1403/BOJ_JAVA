import java.util.*;

public class Q16206 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int left = sc.nextInt();
        LinkedList<Integer> listzero= new LinkedList<>();
        LinkedList<Integer> number = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0; i<n; i++){
            int a= sc.nextInt();
            if(a%10==0){
                listzero.add(a);
            }
            else{
                number.add(a);
            }
        }
        int answer =0;
        Collections.sort(listzero);
        Collections.sort(number);
        int zerosize = listzero.size();
        int numbersize = number.size();
        for(int i=0; i<zerosize;i++) list.add(listzero.poll());
        for(int i=0; i<numbersize; i++) list.add(number.poll());
        int size = list.size();
        for(int i=0 ; i<size; i++){
            if(list.size()==0) break;
            int a = list.poll();
            if(a%10==0){
                if(left >=a/10-1){
                    answer+= a/10;
                    left-=a/10-1;
                }
               else{
                   answer+=left;
                   left = 0;
                   break;
                }
            }
            else{
                if(left>=a/10){
                    answer+=a/10;
                    left-=a/10;
                }
                else{
                    answer+=left;
                    left=0;
                }
            }
        }
        System.out.println(answer);
    }
}
/*
5 5
10 10 10 10 10
*/