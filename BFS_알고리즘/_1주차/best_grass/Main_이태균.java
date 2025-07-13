package _1주차.best_grass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int R, C;
    private static char[][] MAP;
    private static boolean[][] VISITED;
    private static final int[] DX = {0, -1, 0, 1};
    private static final int[] DY = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        MAP = new char[R][C];
        VISITED = new boolean[R][C];

        for (int row = 0; row < R; row++) {
            char[] chars = br.readLine().toCharArray();
            for (int col = 0; col < C; col++) {
                MAP[row][col] = chars[col];
            }
        }

        int count = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (MAP[i][j] == '#' && !VISITED[i][j]) {
                    bfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static void bfs(int row, int col) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col));
        VISITED[row][col] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int next_row = node.row + DX[i];
                int next_col = node.col + DY[i];

                if (next_row >= 0 && next_col >= 0 && next_row < R && next_col < C) {
                    if (MAP[next_row][next_col] == '#' && !VISITED[next_row][next_col]) {
                        VISITED[next_row][next_col] = true;
                        queue.add(new Node(next_row, next_col));
                    }
                }
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