package Graph;

import java.util.*;

public class BJ_1260 {
    static StringBuilder sb = new StringBuilder();
    static class Node {
        List<Integer> link;

        public Node(int a) {
            this.link = new ArrayList<>();
            link.add(a);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();//정점의 개수
        int M = sc.nextInt();//간선의 개수
        int V = sc.nextInt();//시작 정점 번호

        Node [] nodes = new Node[N+1];

        for(int i=0; i<M; i++){
            int temp = sc.nextInt();
            int temp2 = sc.nextInt();
            if(nodes[temp] == null)
                nodes[temp] = new Node(temp2);
            else
                nodes[temp].link.add(temp2);

            if(nodes[temp2] == null)
                nodes[temp2] = new Node(temp);
            else
                nodes[temp2].link.add(temp);
        }

        DFS(nodes, V, new boolean[N+1]);
        sb.append("\n");
        BFS(nodes, V, N);

        System.out.println(sb);
    }

    static void BFS(Node[] nodes, int start, int N){
        Queue<Integer> que = new LinkedList<>();
        boolean []visited = new boolean [N+1];

        que.offer(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int cur = que.poll();
            sb.append(cur).append(" ");

            if(nodes[cur]!=null){
                Collections.sort(nodes[cur].link);

                for(int a: nodes[cur].link){
                    if(!visited[a]) {
                        que.offer(a);
                        visited[a] = true;
                    }
                }
            }

        }
    }

    static void DFS(Node[] nodes, int idx, boolean[] visited){

        visited[idx] = true;
        sb.append(idx).append(" ");

        if(nodes[idx]!=null){
            Collections.sort(nodes[idx].link);
            for(int a: nodes[idx].link){
                if(!visited[a]) DFS(nodes, a, visited);
            }
        }

    }
}
