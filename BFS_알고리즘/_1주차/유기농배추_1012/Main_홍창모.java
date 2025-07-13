package BFS_알고리즘._1주차.유기농배추_1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] FIELD;   // 배추밭
    static boolean[][] VISITED;
    static int T, M, N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for ( int i = 0; i < T; i++ ) {
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());   // 배추밭 가로
            N = Integer.parseInt(st.nextToken());   // 배추밭 세로
            K = Integer.parseInt(st.nextToken());   // 배추가 심어져 있는 위치의 개수

            FIELD = new int[M][N];
            VISITED = new boolean[M][N];

            for( int j = 0; j < K; j++ ) {
                st = new StringTokenizer(br.readLine());

                int row = Integer.parseInt(st.nextToken());
                int col = Integer.parseInt(st.nextToken());

                // 배추의 위치를 세팅
                FIELD[row][col] = 1;
            }

            int cabbageWorm = 0;
            for( int a = 0; a < M; a++ ) {
                for( int b = 0; b < N; b++ ) {
                    if( FIELD[a][b] == 1 && !VISITED[a][b] ) {
                        // 배추의 위치인 곳에서만 bfs 실행
                        BFS(a, b);
                        cabbageWorm++;
                    }
                }
            }

            System.out.println(cabbageWorm);
            //System.out.println(Arrays.deepToString(FIELD));
        }
    }

    private static void BFS(int row, int col) {
        Deque<Cabbage> dq = new ArrayDeque<>();

        dq.add(new Cabbage(row, col));
        VISITED[row][col] = true;

        while (!dq.isEmpty()) {
            Cabbage curr = dq.poll();

            int currRow = curr.row;
            int currCol = curr.col;

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 0 && nextRow < M && nextCol >= 0 && nextCol < N && !VISITED[nextRow][nextCol] && FIELD[nextRow][nextCol] == 1) {
                    dq.add(new Cabbage(nextRow, nextCol));
                    VISITED[nextRow][nextCol] = true;
                }
            }
        }
    }

    static class Cabbage {
        int row;
        int col;

        public Cabbage(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
