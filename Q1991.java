import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1991 {
    public static void preorder(int tree[][],int x){
        if(x==-1) return;
        System.out.print((char)(x+'A'));
        preorder(tree , tree[x][0]);
        preorder(tree,tree[x][1]);
    }
    public static void inorder(int tree[][],int x){
        if(x==-1) return;
        inorder(tree, tree[x][0]);
        System.out.print((char)(x+'A'));
        inorder(tree,tree[x][1]);
    }
    public static void postorder(int tree[][],int x){
        if(x==-1) return;
        postorder(tree, tree[x][0]);
        postorder(tree,tree[x][1]);
        System.out.print((char)(x+'A'));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int tree[][] = new int[26][2];
        for(int i=0; i<n; i++){
            String s= br.readLine();
           // System.out.println(s.charAt(0)+" " + s.charAt(2)+ " "+ s.charAt(4));
            if(s.charAt(2) =='.') tree[s.charAt(0)-'A'][0] = -1;
            else  tree[s.charAt(0)-'A'][0] = s.charAt(2)-'A';
            if(s.charAt(4) =='.') tree[s.charAt(0)-'A'][1] = -1;
            else tree[s.charAt(0)-'A'][1] = s.charAt(4)-'A';

        }preorder(tree,0);
        System.out.println();
        inorder(tree,0);
        System.out.println();
        postorder(tree,0);
        System.out.println();

    }
}
