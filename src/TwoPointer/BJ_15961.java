package TwoPointer;

import java.util.Scanner;

public class BJ_15961 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //접시의 수
        int d = sc.nextInt(); //초밥의 가짓수
        int k = sc.nextInt(); //연속해서 먹는 접시의 수
        int c = sc.nextInt(); //쿠폰 번호

        int [] belt = new int [N];
        int [] dishes = new int[d+1];
        for(int i=0; i<N; i++){
            belt[i] = sc.nextInt();
        }

        int start = 0;
        int end = k-1;
        int cnt = 0;


        for(int i=start; i<=end; i++){
            if(dishes[belt[i]] == 0){
                cnt +=1;
            }
            dishes[belt[i]] +=1 ;
        }
        int result = cnt;
        while(true){
            end += 1;
            if(dishes[belt[end]] == 0){
                cnt +=1;
            }
            dishes[belt[end]] +=1;

            if(dishes[belt[start]]==1){
                cnt -=1;
            }
            dishes[belt[start]] -=1;
            start +=1;

            if(dishes[c] ==0 ) cnt +=1;
            result = Math.max(result, cnt);
            if(dishes[c]==0) cnt -=1;

            if(end==N-1) end = -1;
            if(start==N-1) start = 0;
            if(end ==k-1) break;
        }

        System.out.println(result);
    }
}
