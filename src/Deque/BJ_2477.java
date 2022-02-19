package Deque;

import java.util.*;

public class BJ_2477 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int melon = sc.nextInt();
        Deque<int[]> field = new LinkedList<>();
        int count [][] = new int [5][2];
        for(int i=0; i<6; i++){
            int temp = sc.nextInt();
            count[temp][0] +=1;
            int temp2 = sc.nextInt();
            count[temp][1]= temp2;
            field.offer(new int [] {temp, temp2});
        }
        int x=1;
        for(int i=0; i<6; i++){
            int [] a = field.pollFirst();
            int [] b = field.pollFirst();
            int [] c = field.peek();

            if(a[0] ==c[0]) x*= b[1];

            field.offerLast(a);
            field.offerFirst(b);
        }
        int y=1;
        for(int[] a: count){
            if(a[0]==1) y*=a[1];
        }

        System.out.println((y-x)*melon);
    }

}
