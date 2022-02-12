package Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW_2001 {
    public static void main(String[] args) {
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(bf.readLine());
            int size;
            int size2;
            int map [][];
            for(int i=0; i<n;i++){
                String[]temp =bf.readLine().split(" ");
                size = Integer.parseInt(temp[0]);
                size2 = Integer.parseInt(temp[1]);
                map = new int [size][size];
                for(int j=0; j<size; j++){
                    String temp2 [] =bf.readLine().split(" ");
                    for(int k=0; k<size; k++){
                        map[j][k] = Integer.parseInt(temp2[k]);
                    }
                }
                System.out.printf("#%d %d%n", i+1, killfly(map, size, size2));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int killfly(int[][] map, int size, int n){//n은 작은 square
        int max = 0;
        int temp = 0;
        for(int r=0; r<=size-n; r++){
            for(int c=0; c<=size-n; c++){
                temp=0;
                for(int i=0; i<n; i++){
                    for(int j=0; j<n; j++){
                        temp += map[r+i][c+j];
                    }
                }
               if(temp > max) max = temp;
            }
        }

        return max;

    }
}
