package 문제풀이.BFS.그림_1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static boolean[][] VISITED;

    static int[][] MAP;

    static int N, M;

    static int MAX_VALUE = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        MAP = new int[N][M];
        VISITED = new boolean[N][M];

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < M; j++ ) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int pictureCnt = 0;
        for( int i = 0; i < N; i++ ) {
            for( int j = 0; j < M; j++ ) {
                if( MAP[i][j] == 1 && !VISITED[i][j] ) {
                    bfs(i, j);
                    pictureCnt++;
                }

            }
        }

        // 그림의 개수
        System.out.println(pictureCnt);
        // 가장 큰 넓이 출력
        System.out.println(MAX_VALUE);
    }

    static void bfs(int row, int col) {
        Deque<Picture> dq = new ArrayDeque<>();

        dq.add(new Picture(row, col));
        VISITED[row][col] = true;

        // 처음에 1인것만 돌기때문에 자기 자신부터 1의 개수 세팅
        int size = 1;

        while (!dq.isEmpty()) {
            Picture curr = dq.poll();

            int currRow = curr.row;
            int currCol = curr.col;

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !VISITED[nextRow][nextCol] && MAP[nextRow][nextCol] == 1 ) {
                    VISITED[nextRow][nextCol] = true;
                    dq.add(new Picture(nextRow, nextCol));
                    size++;
                }

            }

        }

        MAX_VALUE = Math.max(MAX_VALUE, size);
    }

    static class Picture {
        int row;
        int col;

        public Picture(int row, int col) {
            this.row = row;
            this.col = col;
        }

    }
}
