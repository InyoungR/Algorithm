package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1275_커피숍2 {
    static int [] arr = null;
    static long [] segmentTree = null;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        segmentTree = new long [N*4];

        st = new StringTokenizer(bf.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeSegmentTree(1, 1, N);

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            long diff = val-arr[idx];

            sb.append(sum(1, 1, N, Math.min(a,b),Math.max(a,b))).append("\n");
            updateSegment(1, 1, N, idx, diff);
            arr[idx] = val;

        }

        System.out.println(sb);
    }

    static long makeSegmentTree(int node, int start, int end){
        if(start == end) return segmentTree[node] = arr[start];

        int mid = (start+end)/2;
        long leftResult = makeSegmentTree(node*2, start, mid);
        long rightResult = makeSegmentTree(node*2+1, mid+1,end);
        segmentTree[node] = leftResult+rightResult;

        return segmentTree[node];
    }

    static long sum(int node, int start, int end, int left, int right){
        if(left>end || right<start) return 0;
        if(left<=start && end<=right) return segmentTree[node];

        int mid = (start+end)/2;
        long leftResult = sum(node*2, start, mid, left, right);
        long rightResult = sum(node*2+1, mid+1, end, left, right);

        return leftResult+rightResult;
    }

    static void updateSegment(int node, int start, int end, int idx, long diff){

        if(idx<start || end<idx) return;

        segmentTree[node] += diff;

        if(start != end){
            int mid = (start+end)/2;
            updateSegment(node*2, start, mid, idx, diff);
            updateSegment(node*2+1, mid+1, end, idx, diff);
        }
    }
}
