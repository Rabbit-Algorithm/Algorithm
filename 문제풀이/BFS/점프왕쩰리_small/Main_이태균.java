package 문제풀이.BFS.점프왕쩰리_small;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main_이태균 {

    private static int N;
    private static int[][] MAP;
    private static Map<Integer, Map[][]> GO = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        MAP = new int[N][N];
        for (int row = 0; row < N; row++) {
            char[] chars = br.readLine().toCharArray();
            for (int col = 0; col < N; col++) {
                MAP[row][col] = Integer.parseInt(String.valueOf(chars[col]));
            }
        }

        dfs(0, 0);
    }

    private static void dfs(int row, int col) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(row, col));

        while (!stack.isEmpty()) {
            Node node = stack.peek();
            int now_row = node.row;
            int now_col = node.col;
            int now_val = MAP[now_row][now_col];

            GO.put(0, new Map[now_row][now_col + now_val]);
            GO.put(1, new Map[now_row + now_val][now_col]);

            for (int i = 0; i < 2; i++) {
                Map[][] now_map = GO.get(i);
                Map[] maps = now_map[0];

                System.out.println(maps);
            }
        }
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

}