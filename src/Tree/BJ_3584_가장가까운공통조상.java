package Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_3584_가장가까운공통조상 {
    static class tree{
        int p, d; //parent p 와 depth d

        public tree(int p) {
            this.p = p;
        }
    }
    static tree [] trees = null;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(bf.readLine());

        for(int t=0; t<T; t++){
            int n = Integer.parseInt(bf.readLine());

            trees = new tree [n+1];

            for(int i=0; i<n-1; i++){
                st = new StringTokenizer(bf.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                trees[c] = new tree(p);
            }
            st = new StringTokenizer(bf.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            findDepth(a);
            findDepth(b);

            int result = findParent(a,b);
            sb.append(result).append("\n");

        }
        System.out.println(sb);

    }

    static int findDepth(int a){
        if( trees[a] == null || trees[a].p == a ) {
            trees[a] = new tree(a);
            return 0;
        }
        if(trees[a].d != 0) return trees[a].d;
        trees[a].d = findDepth(trees[a].p) + 1;
        return trees[a].d;
    }

    static int findParent(int a, int b){

        while(trees[a].d != trees[b].d){
            if(trees[a].d>trees[b].d){
                a = trees[a].p;
            } else if(trees[a].d<trees[b].d){
                b = trees[b].p;
            }
        }

        while(a != b){
            a = trees[a].p;
            b = trees[b].p;
        }

        return a;
    }
}
