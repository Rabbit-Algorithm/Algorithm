package pccp._2번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_이승환 {

    static int N;
    static int K;

    static int[] visited;

    static class Node{
        int value;
        Node nextNode;

        public Node(int value, Node nextNode) {
            this.value = value;
            this.nextNode = nextNode;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new int[N];

        K = Integer.parseInt(br.readLine());



        new Node(1,new Node(4));





    }



}
