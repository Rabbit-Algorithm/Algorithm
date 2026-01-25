package 문제풀이.DFS.전쟁_전투_1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N, M;
    static char[][] BOARD;
    static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BOARD = new char[M][N];
        VISITED = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                BOARD[i][j] = str.charAt(j);
            }
        }

        int w_answer = 0;
        int b_answer = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char c = BOARD[i][j];
                if( c == 'W' && !VISITED[i][j] ) {
                    int result_w = dfs(i, j, c);

                    w_answer += result_w * result_w;
                } else if( c == 'B' && !VISITED[i][j] ) {
                    int result_b = dfs(i, j, c);

                    b_answer += result_b * result_b;
                }
            }
        }

        System.out.println(w_answer + " " + b_answer);

    }

    private static int dfs( int row, int col, char target ) {
        Stack<Node> stack = new Stack<>();
        VISITED[row][col] = true;

        stack.push(new Node(row, col));

        int total = 0;
        while (!stack.isEmpty()) {
            Node curr =  stack.pop();

            total++;
            for(int i = 0; i < 4; i++) {
                int nextRow = curr.row + dx[i];
                int nextCol = curr.col + dy[i];

                if( nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N ) {
                    if( !VISITED[nextRow][nextCol] && BOARD[nextRow][nextCol] == target ) {
                        stack.push(new Node(nextRow, nextCol));
                        VISITED[nextRow][nextCol] = true;
                    }
                }
            }

        }
        return total;
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

