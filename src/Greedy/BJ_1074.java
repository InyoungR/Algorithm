package Greedy;

import java.util.Scanner;

public class BJ_1074 {
	static int N, R, C, answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		int size = 1<<N;
		answer = 0;
		visit(size, 0, 0);
		
	}
	
	public static void visit(int size, int r, int c) {
		if(checkValue(r,c)) {
			System.out.println(answer);
			return;
		}
		
		int half = size/2;
		if(isRange(size, r, c)) {
			visit(half, r, c);
			visit(half, r, c+half);
			visit(half, r+half, c);
			visit(half, r+half, c+half);
		} else {
			answer += size*size;
		}
		
	}
	
	static boolean checkValue(int y, int x) {return y==R && x==C;}
	static boolean isRange(int size, int y, int x) {return R<y+size && R>=y && C<x+size && C>=x;}
}
