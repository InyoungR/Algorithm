package Sort;

import java.util.*;

public class BJ_11067 {

    static class cafe implements Comparable<cafe>{
        int x, y, no;

        public cafe(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(cafe o) {
            return x==o.x? y-o.y:x-o.x;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        PriorityQueue<cafe> que = new PriorityQueue<>();
        for(int t =0; t<T; t++){
            int m = sc.nextInt();
            for(int i=0; i<m; i++){
                que.add(new cafe(sc.nextInt(),sc.nextInt()));
            }
            int n = sc.nextInt();
            int [] numbers = new int [n];
            for(int i=0; i<n; i++){
                numbers[i] = sc.nextInt();
            }

            int x, y = 0;
            cafe [] cafes = new cafe[m];
            int cnt = 0;
            while(!que.isEmpty()){
                ArrayList<cafe> same = new ArrayList<>();
                cafe cafe = que.poll();
                same.add(cafe);
                while(!que.isEmpty() && cafe.x == que.peek().x){
                    same.add(que.poll());
                }
                Collections.sort(same);

                if(y<=same.get(0).y){
                    for(cafe cafe1:same){
                        cafes[cnt++] =cafe1;
                    }
                } else {
                    for(int j=same.size()-1;j>=0; j--){
                        cafes[cnt++] = same.get(j);
                    }
                }

                y = cafes[cnt-1].y;
            }

            for(int i=0; i<n; i++){
                cafe temp = cafes[numbers[i]-1];
                sb.append(temp.x).append(" ").append(temp.y).append("\n");
            }
        }
        System.out.println(sb);
    }

}
