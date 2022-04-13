package MonthTest;

import java.util.Scanner;

public class RabbitRace {
    static class rabbit{
        int up,down;

        public rabbit(int up, int down) {
            this.up = up;
            this.down = down;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();

        for(int t=1; t<=T; t++){
            int [] heights = new int [10];
            rabbit [] rabbits = new rabbit[5];

            for(int i=0; i<10; i++){
                heights[i] = sc.nextInt();
            }

            for(int i=0; i<5; i++){
                rabbits[i] = new rabbit(sc.nextInt(),sc.nextInt());
            }
            int cnt = 0;
            outer: for(int r=0; r<5; r++){
                for(int i=0; i<9; i++){
                    //오르막일 경우
                    if(heights[i] < heights[i+1] && heights[i+1] -heights[i] > rabbits[r].up){
                        continue outer;
                    //내리막일 경우
                    } else if (heights[i] > heights[i+1] && heights[i] -heights[i+1] > rabbits[r].down){
                        continue outer;
                    }
                }
                cnt++;
            }
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
