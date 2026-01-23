package 문제풀이.DFS.안전영역_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int[] DX = {-1, 0, 1, 0};
    static int[] DY = {0, -1, 0, 1};
    static int N, MAX = Integer.MIN_VALUE, ANSWER = Integer.MIN_VALUE;
    static int[][] CITY;
    static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        CITY = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int target = Integer.parseInt(st.nextToken());
                CITY[i][j] = target;
                MAX = Math.max(MAX, target);
            }
        }

        for (int i = 0; i <= MAX; i++) {
            int count = 0;
            VISITED = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if( CITY[j][k] > i && !VISITED[j][k] ) {
                        dfs(j, k, i);
                        count++;
                    }
                }
            }
            ANSWER = Math.max(ANSWER, count);
        }

        System.out.println(ANSWER);

    }

    private static void dfs(int row, int col, int height) {
        Stack<Node> stack = new Stack<>();
        VISITED[row][col] = true;

        stack.push(new Node(row, col));

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + DX[i];
                int nextCol = curr.col + DY[i];

                if( nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && CITY[nextRow][nextCol] > height && !VISITED[nextRow][nextCol] ) {
                    dfs(nextRow, nextCol, height);
                    VISITED[nextRow][nextCol] = true;
                }
            }
        }
    }

    private static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
