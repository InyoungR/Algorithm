package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471 {
    static class Node{
        int val, no;
        Node link;

        public Node(int val, int no, Node link) {
            this.val = val;
            this.no = no;
            this.link = link;
        }
    }

    static Node [] nodes;
    static int n, result;
    static int[] temp = new int [n+1];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        nodes = new Node[n+1];
        temp = new int [n+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=n; i++){
            temp[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());

            for(int j=0; j<k; j++){
                int t = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(temp[t], t, nodes[i]);
            }
        }
        result = Integer.MAX_VALUE;

        DFS(1,1<<1);

        System.out.println(result==Integer.MAX_VALUE?-1:result);

    }

    static void DFS(int idx, int flag) {

        if (idx > n) {
            return;
        }

        int ck = check(flag);
        int ck2 = check2(flag);
        if(ck>0 && ck2>0){
            result = Math.min(result, Math.abs(ck-ck2));
        }
        int flag2 = flag | 1<<idx;
        ck = check(flag2);
        ck2 = check2(flag2);
        if(ck>0 && ck2>0){
            result = Math.min(result, Math.abs(ck-ck2));
        }
        DFS(idx+1, flag);
        DFS(idx+1, flag2);
    }
    static int check(int flag){
        int flag2 = 0;
        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if((flag & 1 << i) != 0 ) { //현재팀에 포함되어 있다면
                flag2 |= 1<<i;
                que.add(i);
                cnt += temp[i];
                break;
            }
        }

        while(!que.isEmpty()){
            for (Node node = nodes[que.poll()]; node != null; node = node.link) {
                if((flag & 1 << node.no) != 0 && (flag2 & 1 << node.no) == 0) { //현재팀에 있고, 아직 방문하지 않았다면
                    flag2 |= 1<<node.no;
                    que.add(node.no);
                    cnt += node.val;
                }
            }
        }

        if(flag == flag2) return cnt;
        else return -1;
    }
    static int check2(int flag){
        int flag2 = 0;
        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;
        for(int i=1; i<=n; i++){
            if((flag & 1 << i) == 0 ) { //다른팀에 포함되어 있지 않다면
                flag2 |= 1<<i;
                que.add(i);
                cnt += temp[i];
                break;
            }
        }

        while(!que.isEmpty()){
            for (Node node = nodes[que.poll()]; node != null; node = node.link) {
                if((flag & 1 << node.no) == 0 && (flag2 & 1 << node.no) == 0) { //다른팀에 포함되어 있지 않다면
                    flag2 |= 1<<node.no;
                    que.add(node.no);
                    cnt += node.val;
                }
            }
        }

        int flag3 = flag | flag2;
        boolean X = false;

        for(int i=1; i<=n; i++){
            if((flag3 & 1<<i)==0){
                X = true;
            }
        }

        if(X) return -1;
        else return cnt;
    }
}
