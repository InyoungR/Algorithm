package Util;

import java.util.ArrayList;
import java.util.List;

public class Bitmask_Subset {

	public static void main(String[] args) {
		int [] Arr = {7,8,5,19};
		
		//System.out.println(1<<Arr.length);
		
		f(Arr,Arr.length);

	}
	
	private static void f(int[]arr, int N) {
		for(int i=0; i<(1<<N); i++) {
			List<Integer> list = new ArrayList<>();
			if(count(i)==2) {
				for(int j=0; j<N;j++) {
					if((i & (1<<j))!=0) list.add(arr[j]);
				}
			}
			if(!list.isEmpty()) System.out.println(list);
			//System.out.println(list);
		}
	}

	public static int count(int value) {
		int count=0;
		while(value>0) {
			if((value&1)==1) count++;
			value=value>>1;
		}
		return count;
	}
}
