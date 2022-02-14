package Bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_20304_수정중 {

    static Queue<int[]> q = new LinkedList<>();
    static int visit [];
    static int N, M, ans;

    public static void main(String[] args) throws IOException {
        //입력 받기 위한 bufferedReader 생성
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //입력을 공백에 따라 쪼개기 위한 StringTokenizer
        StringTokenizer st;
        //인쇄를 위한 StringBuilder

        //관리자 패스워드의 최댓값 N, 해커가 사용한 패스워드의 개수 M
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());

        visit = new int [N+1];
        Arrays.fill(visit, -1);

        st = new StringTokenizer(bf.readLine());
        for(int i=0; i<M; i++) {
            int x = Integer.parseInt(st.nextToken());
            q.add(new int [] {x,0});
            visit[x]=0;
        }

        //보안척도
        int security=0;
        //보안척도의 최솟값인 보안성 min
        int min= Integer.MAX_VALUE;
        //정답
        int result = 0;

        for(int j=N; j>=0; j--) {
            //해커가 시도했던 패스워드 전체 목록을 돌며 보안성의 최솟값인 보안척도 구하기
            min = Integer.MAX_VALUE;
            for(int i=0; i<M; i++) {
                //int temp = passwords[i]^N;
                security = 0;
                //보안성 구하기
                //while((temp&(1<<security))!=0){
                    security +=1;
                }
                min = Math.min(min, security);
            }
            result = Math.max(result, min);
        }
       // System.out.println(result);

   // }

    static void bfs(){
        while(!q.isEmpty()){
            int x = q.peek()[0];
            int cnt = q.poll()[1];

            ans = Math.max(ans, cnt);
            for(int i=1; i<=N; i=i<<1){
                int y = x&i;
            }
        }
    }
}
