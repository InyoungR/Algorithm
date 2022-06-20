package TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        HashMap<Integer,Integer> nums = new HashMap<>();
        int [] nums2 = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for(int i=0; i<n; i++){
           int num = Integer.parseInt(st.nextToken());
           nums2[i] = num;

           if(nums.containsKey(num)){
               nums.put(num,nums.get(num)+1);
           } else {
               nums.put(num,1);
           }
        }

        int answer = 0;

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int num = nums2[i] + nums2[j];
                if(nums.containsKey(num)){
                    if((num== nums2[i] || num == nums2[j]) && nums.get(num)==1)continue;
                    if(nums2[i] == nums2[j] && num == nums2[j] && nums.get(num)==2) continue;
                    answer += nums.get(num);
                    nums.remove(num);
                }
            }
        }

        System.out.println(answer);
    }
}
