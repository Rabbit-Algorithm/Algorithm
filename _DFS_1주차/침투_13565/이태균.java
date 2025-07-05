package 침투_13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 이태균 {
    private static int N, M;
    private static int[][] FIGURE;
    private static boolean[][] VISITED;
    private static int[] DX = {-1, 0, 1, 0};
    private static int[] DY = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        FIGURE = new int[N][M];
        VISITED = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                FIGURE[i][j] = line.charAt(j) - '0';
            }
        }

        boolean success = false;
        for (int j = 0; j < M; j++) {
            if (FIGURE[0][j] == 0 && !VISITED[0][j]) {
                if (dfs(0, j)) {
                    success = true;
                    break;
                }
            }
        }

        System.out.println(success ? "YES" : "NO");
    }

    private static boolean dfs(int row, int col) {
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(row, col));
        VISITED[row][col] = true;

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int now_row = node.row;
            int now_col = node.col;

            if (now_row == N - 1) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                int next_row = now_row + DX[d];
                int next_col = now_col + DY[d];
                if (next_row >= 0 && next_row < N && next_col >= 0 && next_col < M) {
                    if (!VISITED[next_row][next_col] && FIGURE[next_row][next_col] == 0) {
                        VISITED[next_row][next_col] = true;
                        stack.push(new Node(next_row, next_col));
                    }
                }
            }
        }
        return false;
    }

    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}

// dp[n] = dp[n-1] + n; // <--- 쉽게 할 수 있어요
// 뮤탈리스크 시간초과 -> 해설 찾아보면 dp로 풀이

