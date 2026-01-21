package 문제풀이.BFS.나이트의이동_7562_실버1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    static int N, T;
    static int[][] BOARD;
    static boolean[][] VISITED;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            BOARD = new int[N][N];
            VISITED = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());

            Position startPos = new Position(
                    startRow,
                    startCol,
                    0
            );

            st = new StringTokenizer(br.readLine());
            int endRow = Integer.parseInt(st.nextToken());
            int endCol = Integer.parseInt(st.nextToken());

            Position endPos = new Position(
                    endRow,
                    endCol,
                    -1
            );

            bfs(startPos, endPos);
        }

        System.out.print(SB);
    }

    private static void bfs(Position startPos, Position endPos) {

        Deque<Position> dq = new LinkedList<>();

        if( startPos.row == endPos.row && startPos.col == endPos.col ){
            SB.append(0).append("\n");
            return;
        }

        dq.add(startPos);
        VISITED[startPos.row][startPos.col] = true;

        while (!dq.isEmpty()) {
            Position currPos = dq.poll();

            int currRow = currPos.row;
            int currCol = currPos.col;
            int currDist = currPos.dist;

            for (int i = 0; i < 8; i++) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < N && !VISITED[nextRow][nextCol]) {

                    if( nextRow == endPos.row && nextCol == endPos.col ) {
                        SB.append(currDist+1).append("\n");
                        return;
                    }

                    dq.add(new Position(nextRow, nextCol, currDist+1));
                    VISITED[nextRow][nextCol] = true;
                }
            }
        }

    }

    private static class Position {
        int row;
        int col;
        int dist;

        public Position(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}