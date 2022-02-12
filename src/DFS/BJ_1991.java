package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1991 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(bf.readLine());

        Tree tree = new Tree();

        for(int i=1; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            tree.Add(st.nextToken(),st.nextToken(),st.nextToken());
        }

        tree.PreOrder(tree.Root);
        System.out.println();
        tree.InOrder(tree.Root);
        System.out.println();
        tree.PostOrder(tree.Root);

    }

    static class Node {
        String value;
        Node left, right;

        public Node(String value) {
            this.value = value;
        }
    }

    static class Tree {
        Node Root;

        public void Add(String value, String left_data, String right_data){
            if(Root == null){
                if(!value.equals(".")) Root = new Node(value);
                if(!left_data.equals(".")) Root.left = new Node(left_data);
                if(!right_data.equals(".")) Root.right = new Node(right_data);
            } else Search(Root, value, left_data, right_data);
        }

        public void Search(Node Root, String value, String left_data, String right_data){
            if(Root==null) return;

            else if(Root.value.equals(value)){
                if(!left_data.equals(".")) Root.left = new Node(left_data);
                if(!right_data.equals(".")) Root.right = new Node(right_data);
            }

            else {
                Search(Root.left, value, left_data, right_data);
                Search(Root.right, value, left_data, right_data);
            }
        }

        void PreOrder(Node Root){
            System.out.print(Root.value);
            if(Root.left!=null) PreOrder(Root.left);
            if(Root.right!=null) PreOrder(Root.right);
        }

        void InOrder(Node Root){
            if(Root.left!=null) InOrder(Root.left);
            System.out.print(Root.value);
            if(Root.right!=null) InOrder(Root.right);
        }

        void PostOrder(Node Root){
            if(Root.left!=null) PostOrder(Root.left);
            if(Root.right!=null) PostOrder(Root.right);
            System.out.print(Root.value);
        }
    }
}

