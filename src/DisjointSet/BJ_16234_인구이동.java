package DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16234_인구이동 {
    static int [] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken()); //땅의 크기
        int L = Integer.parseInt(st.nextToken()); //최소 한계
        int R = Integer.parseInt(st.nextToken()); //최대 한계

        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int answer = 0;

        while(true){
            makeSet(N*N);
            boolean flag = false;
            HashSet<Integer> roots = new HashSet<>();
            //국경이 열린 나라들끼리 union
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    int root = i*N+j;

                    for(int dir = 0; dir<4; dir++){
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];

                        if(nr<0 || nc<0 || nr>=N || nc>=N) continue;

                        int diff = Math.abs(map[i][j]-map[nr][nc]);
                        if(diff>=L && diff<=R) {
                            union(root, nr*N+nc);
                            flag = true;
                        }
                    }
                }
            }

            //국경이 하나도 열려있지 않다면 break, 하나라도 열려있다면 인구이동 및 횟수++
            if(!flag) break;
            answer++;

            for(int i=0; i<N*N; i++){
                int root = findSet(i);
                roots.add(root);
            }

            HashMap<Integer, Integer> sums = new HashMap<>();
            HashMap<Integer, Integer> cnts = new HashMap<>();

            for(int root: roots){
                sums.put(root, 0);
                cnts.put(root,0);
            }

            for(int i=0; i<N*N; i++){
                int root = findSet(i);
                int r = i/N;
                int c = i%N;

                sums.put(root, sums.get(root) + map[r][c]);
                cnts.put(root, cnts.get(root)+1);
            }

            for(int i=0; i<N*N; i++){
                int r = i/N;
                int c = i%N;
                int root = findSet(i);
                map[r][c] = sums.get(root)/cnts.get(root);
            }

        }

        System.out.println(answer);

    }

    static void makeSet(int n){
        parents = new int [n];
        for(int i=0; i<n; i++){
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
        parents[aRoot] = bRoot;
        return true;
    }
}
