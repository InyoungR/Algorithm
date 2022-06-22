package Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12100_2048 {
    static int n, result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int [][] board = new int [n][n];

        StringTokenizer st = null;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Play(board, 0);

        System.out.println(result);
    }

    static void Play(int[][] board, int cnt){
        if(cnt == 5) {
            int max = 0;

            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    max = Math.max(max, board[i][j]);
                }
            }
            result = Math.max(result, max);
            return;
        }

        int[][] board2 = copy(board);

        Play(Up(board2),cnt+1);
        board2 = copy(board);
        Play(Down(board2),cnt+1);
        board2 = copy(board);
        Play(Left(board2),cnt+1);
        board2 = copy(board);
        Play(Right(board2),cnt+1);


    }

    static int [][] copy(int [][] arr) {
        int[][] copy = new int[n][n];

        for (int i = 0; i < n; i++) {
            copy[i] = arr[i].clone();
        }

        return copy;
    }

    static int [][] Up(int [][] arr){
        for(int j=0; j<n; j++){
            int i=0;
            while(i<n-1){
                boolean flag = false;
                int k = i+1;
                while(arr[k][j] == 0 && k<n-1)k++;

                if(arr[i][j] != 0 && arr[i][j] != arr[k][j]) {
                    i++;
                    continue;
                }

                if(arr[i][j] != 0) flag = true;

                arr[i][j] += arr[k][j];
                arr[k][j] = 0;

                if(flag) i++;
                if(k==n-1)break;
            }
        }
        return arr;
    }

    static int [][] Down(int [][] arr){
        for(int j=0; j<n; j++){
            int i=n-1;
            while(i>0){
                int k = i-1;
                boolean flag = false;
                while(arr[k][j] == 0 && k>0)k--;

                if(arr[i][j]!=0 && arr[i][j] != arr[k][j]) {
                    i--;
                    continue;
                }

                if(arr[i][j] != 0) flag = true;

                arr[i][j] += arr[k][j];
                arr[k][j] = 0;

                if(flag) i--;
                if(k==0)break;

            }
        }


        return arr;
    }

    static int [][] Left(int [][] arr){
        for(int i=0; i<n; i++){
            int j=0;
            while(j<n-1){
                int k = j+1;
                boolean flag = false;
                while(arr[i][k] == 0 && k<n-1)k++;

                if(arr[i][j]!=0 && arr[i][j] != arr[i][k]) {
                    j++;
                    continue;
                }
                if(arr[i][j] != 0) flag = true;
                arr[i][j] += arr[i][k];
                arr[i][k] = 0;

                if(flag) j++;
                if(k==n-1) break;

            }

        }

        return arr;
    }

    static int [][] Right(int [][] arr){
        for(int i=0; i<n; i++){
            int j= n-1;
            while(j>0){
                int k = j-1;
                boolean flag = false;
                while(arr[i][k] == 0 && k>0)k--;

                if(arr[i][j]!=0 && arr[i][j] != arr[i][k]) {
                    j--;
                    continue;
                }
                if(arr[i][j] != 0) flag = true;
                arr[i][j] += arr[i][k];
                arr[i][k] = 0;

                if(flag) j--;
                if(k==0) break;
            }

        }


        return arr;
    }

}
