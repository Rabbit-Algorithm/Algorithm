package 문제풀이.DFS.농장관리_1245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 슈도코드
 * // 상하좌우 + 대각선 이동이 가능
 * // dx, dy 선언
 *
 * BOARD = new int[M][N];
 * VISITED = new int[M][N];
 *
 * for( 0 부터 M ) {
 *     for( 0 부터 N ) {
 *         // 격자의 높이 세팅
 *     }
 * }
 *
 * void dfs(start, end) {
 *    // 스택 선언
 *    stack.push(내부 클래스 선언);
 *
 *    while(!stack.isEmpty()) {
 *        for( 0 부터 8 ) {
 *            nextRow = currRow + DX[i];
 *            nextCol = currCol + DY[i];
 *
 *            //
 *            if(  )
 *        }
 *    }
 * }
 *
 * */

public class Main_홍창모 {

    static int[] DX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] DY = {0, 0, -1, 1, -1, 1, -1, 1};
    static int N, M;
    // 봉우리 여부
    static boolean isPeaks;
    static int[][] BOARD;
    static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BOARD = new int[N][M];
        VISITED = new boolean[N][M];

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++ ) {
                BOARD[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for( int i = 0; i < N; i++ ) {
            for(int j = 0; j < M; j++ ) {
                if( BOARD[i][j] == 0 ) continue;

                if( !VISITED[i][j] ) {
                    // 방문하지 않았다면 일단 봉우리로 선정
                    isPeaks = true;
                    dfs( i, j, BOARD[i][j] );
                    if( isPeaks ) count++;
                }
            }
        }

        System.out.println(count);

    }

    private static void dfs(int row, int col, int height) {
        Stack<Node> stack = new Stack<>();
        VISITED[row][col] = true;
        stack.push(new Node(row, col));

        while (!stack.isEmpty()) {
            Node curr = stack.pop();

            for (int i = 0; i < 8; i++) {
                int nextRow = curr.row + DX[i];
                int nextCol = curr.col + DY[i];

                if(nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;

                if( BOARD[nextRow][nextCol] > height ) {
                    // 다음 높이가 봉우리로 채택된 높이보다 높은 칸이 있다면 isPeaks = false
                    isPeaks = false;
                }

                if( !VISITED[nextRow][nextCol] && BOARD[nextRow][nextCol] == height ) {
                    VISITED[nextRow][nextCol] = true;
                    stack.push(new Node(nextRow, nextCol));
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
