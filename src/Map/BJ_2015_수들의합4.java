package Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_2015_수들의합4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long [] nums = new long [N];

        st = new StringTokenizer(bf.readLine());
        HashMap<Long, Integer> map = new HashMap<>();

        long cnt = 0L;
        long sum = 0L;
        for(int i=0; i<N; i++){
            sum += Integer.parseInt(st.nextToken());
            nums[i] = sum;
            if(nums[i] == K) cnt++;
            if(map.containsKey(sum-K)){
                cnt += map.get(sum-K);
            }
            if (map.containsKey(sum))  map.put(sum, map.get(sum)+1);
            else map.put(sum, 1);

        }

        System.out.println(cnt);
    }
}
