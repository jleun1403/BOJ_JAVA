import java.util.*;
import java.io.*;

public class Q1406_2{
    public static void main(String args[])throws IOException{
        
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String s [] = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            LinkedList <String> list = new LinkedList <String>();
            
            for(int i=0; i<s.length; i++) {
                list.add(s[i]);
            }
            ListIterator it = list.listIterator(list.size());
            String cmd;
            
            StringTokenizer st;
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                cmd = st.nextToken();
                switch (cmd){
                    case ("L") :
                        if(it.hasPrevious()) {
                         it.previous();
                        }
                        break;
                    case ("D") :
                        if(it.hasNext()) {
                        it.next();
                        }
                        break;
                    case("B") :
                        if(it.hasPrevious()) {
                        it.previous();
                        it.remove(); 
                        }
                    break;
                    case("P") :
                        it.add(st.nextToken());

                } 
            }
            for(String a : list) {
                bw.write(a);
            }
            bw.flush();
            bw.close();
        }
    }
