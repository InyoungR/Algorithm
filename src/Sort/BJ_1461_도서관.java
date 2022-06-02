package Sort;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1461_도서관 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //책의 개수
        int m = sc.nextInt(); //한 번에 들 수 있는 책의 개수

        int max = 0;
        boolean biggest = true; //true이면 양수, false이면 음수로 한다.
        PriorityQueue<Integer> positive = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int a = sc.nextInt();
            if(a>0) positive.add(a);
            else negative.add(a);

            if(Math.abs(a) > max){
                max = Math.abs(a);
                if(a>0) biggest = true;
                else biggest = false;
            }
        }

        int result = 0;
        if(biggest){
            result += positive.poll();
            int cnt = m-1;
            while(!positive.isEmpty() && cnt-->0){
                positive.poll();
            }
        } else {
            result += Math.abs(negative.poll());
            int cnt = m-1;
            while(!negative.isEmpty() && cnt-->0){
                negative.poll();
            }
        }

        while(!positive.isEmpty()){
            result += positive.poll()*2;
            int cnt = m-1;
            while(!positive.isEmpty() && cnt-->0){
                positive.poll();
            }
        }

        while(!negative.isEmpty()){
            result += Math.abs(negative.poll())*2;
            int cnt = m-1;
            while(!negative.isEmpty() && cnt-->0){
                negative.poll();
            }
        }

        System.out.println(result);
    }

}
