package BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697 {
    static int subin, sister, result;
    static Queue<int[]> subins = new LinkedList<>();
    static boolean [] visited = new boolean [100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        subin = sc.nextInt();
        sister = sc.nextInt();
        result = 0;

        Move();

        System.out.println(result);
    }

    static void Move(){
        subins.add(new int[] {subin,0});
        visited[subin] = true;

        while(!subins.isEmpty()){
            int[] curr = subins.poll();

            if(curr[0]==sister){
                result = curr[1];
                break;
            }
            if(curr[0]+1 <= 100000 && !visited[curr[0]+1]){
                subins.add(new int [] {curr[0]+1,curr[1]+1});
                visited[curr[0]+1] = true;
            }

            if(curr[0]-1>=0 && !visited[curr[0]-1]){
                subins.add(new int [] {curr[0]-1,curr[1]+1});
                visited[curr[0]-1] = true;
            }

            if(curr[0]*2 <= 100000 && !visited[curr[0]*2]){
                subins.add(new int [] {curr[0]*2,curr[1]+1});
                visited[curr[0]*2] = true;
            }

        }
    }

}
