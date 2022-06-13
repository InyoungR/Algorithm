package Etc;

public class TEST {
    public static void main(String[] args) {
        DFS(1);
    }

    static void DFS(int n){
        if(n == 15) {
            System.out.println();
            return;
        }
        System.out.print(n+2+" ");
        DFS(n+2);
        System.out.print(n+2+" ");

    }
}
