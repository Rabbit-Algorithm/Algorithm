package 문제풀이.DFS.유기농배추_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int[] DX = {-1, 0, 1, 0};
    static int[] DY = {0, 1, 0, -1};
    static int T;

    static int[][] MAP;
    static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            MAP = new int[M][N];
            VISITED = new boolean[M][N];

            int K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());

                // 배추의 위치
                MAP[row][col] = 1;
            }

            int count = 0;

            for( int j = 0; j < M; j++ ) {
                for (int k = 0; k < N; k++) {
                    if( !VISITED[j][k] && MAP[j][k] == 1 ) {
                        dfs(j, k, M, N);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int row, int col, int M, int N ) {
        Stack<Node> stack = new Stack<>();

        VISITED[row][col] = true;
        stack.push(new Node(row, col));

        while(!stack.isEmpty()) {
            Node curr = stack.pop();

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + DX[i];
                int nextCol = curr.col + DY[i];

                if( nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N && MAP[nextRow][nextCol] == 1 && !VISITED[nextRow][nextCol] ) {
                    stack.push(new Node(nextRow, nextCol));
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
