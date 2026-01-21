package 문제풀이.DFS.영역구하기_2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int M, N, K;
    static int[] DX = {-1, 0, 1, 0};
    static int[] DY = {0, -1, 0, 1};
    static int[][] BOARD;
    static List<Integer> ANSWER = new ArrayList<>();
    static StringBuilder SB = new StringBuilder();
    static boolean[][] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BOARD = new int[M][N];
        VISITED = new boolean[M][N];

        for (int i = 0; i < K; i++) {
           st = new StringTokenizer(br.readLine());

           // 왼쪽 아래 x, y 좌표
           int start_x = Integer.parseInt(st.nextToken());
           int start_y = Integer.parseInt(st.nextToken());
           // 오른쪽 위 x, y 좌표
           int end_x = Integer.parseInt(st.nextToken());
           int end_y = Integer.parseInt(st.nextToken());

           // 직사각형 영역 채우기
           fillRectangular(start_x, start_y, end_x, end_y);
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if( BOARD[i][j] != 1 && !VISITED[i][j] ) {
                    int result = dfs(i, j);
                    ANSWER.add(result);
                    count++;
                }
            }
        }

        // 오름차순 정렬
        ANSWER.sort(null);

        SB.append(count).append("\n");
        for( int x : ANSWER ) {
            SB.append(x).append(" ");
        }

        System.out.print(SB);
    }

    private static int dfs(int row, int col) {
        Stack<Node> stack = new Stack<>();
        VISITED[row][col] = true;
        stack.push(new Node(row, col));

        // 분리된 영역의 넓이를 저장할 변수
        int totalCnt = 0;
        while (!stack.empty()) {
            Node curr = stack.pop();

            int currRow = curr.row;
            int currCol = curr.col;
            totalCnt++;

            for(int i = 0; i < 4; i++) {
                int nextRow = currRow + DX[i];
                int nextCol = currCol + DY[i];

                if( nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N && BOARD[nextRow][nextCol] == 0 && !VISITED[nextRow][nextCol] ) {
                    stack.push(new Node(nextRow, nextCol));
                    VISITED[nextRow][nextCol] = true;
                }
            }
        }

        return totalCnt;
    }

    private static void fillRectangular(int startX, int startY, int endX, int endY) {
        for( int y = startY; y < endY; y++ ) {
            for( int x = startX; x < endX; x++ ) {
                int rowIndex = (M - 1) - y;
                int colIndex = x;

                BOARD[rowIndex][colIndex] = 1;
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
