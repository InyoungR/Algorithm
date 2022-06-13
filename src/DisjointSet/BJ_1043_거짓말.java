package DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1043_거짓말 {
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //사람 수
        int M = Integer.parseInt(st.nextToken()); //파티 수
        int[] truth = new int [N];
        int cnt = 0;

        makeSet(N);
        st = new StringTokenizer(bf.readLine());

        int trueN = Integer.parseInt(st.nextToken());
        for(int i=0; i<trueN; i++){
            int a = Integer.parseInt(st.nextToken());
            union(0,a);
            truth[i] = a;
        }

        int party [][] = new int [M][];

        //파티끼리 union
        for(int i=0; i<M; i++){
            st = new StringTokenizer(bf.readLine());
            int p = Integer.parseInt(st.nextToken()); //파티에간 인원수
            party[i] = new int [p];

            for(int j=0; j<p; j++){
                int p1 = Integer.parseInt(st.nextToken()); //파티에 간 사람
                party[i][j] = p1;
                union(party[i][0], p1);
            }
        }

        for(int i=0; i<M; i++){
            if(findSet(0) != findSet(party[i][0])){
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void makeSet(int n){
        parents = new int [n+1];

        for(int i=1; i<=n; i++){
            parents[i] = i;
        }
    }

    static int findSet(int a){
        if(a == parents[a]) return a;
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
}
