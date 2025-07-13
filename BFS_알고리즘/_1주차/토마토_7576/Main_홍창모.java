package BFS_알고리즘._1주차.토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static int[][] STORAGE;
    static boolean[][] VISITED;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 가로 칸의 수
        N = Integer.parseInt(st.nextToken());   // 세로 칸의 수

        STORAGE = new int[N][M];
        VISITED = new boolean[N][M];

        // 익은 토마토를 담을 큐
        Deque<Node> dq = new ArrayDeque<>();

        for( int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for( int j = 0; j < M; j++ ) {
                STORAGE[i][j] = Integer.parseInt(st.nextToken());
                if( STORAGE[i][j] == 1 ) {
                    // 익은 토마토만 큐에 추가
                    dq.add(new Node(i, j, 0));
                    VISITED[i][j] = true;
                }
            }
        }

        int maxDays = BFS(dq);

        for( int i = 0; i < N; i++ ) {
            for( int j = 0; j < M; j++ ) {
                if( STORAGE[i][j] == 0 ) {
                    // BFS 종료 후 안익은 토마토가 있는 경우 -1 출력
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(maxDays);
    }

    private static int BFS(Deque<Node> dq) {
        int maxDays = 0;

        while (!dq.isEmpty()) {
            Node curr = dq.poll();

            int currRow = curr.row;
            int currCol = curr.col;
            int currDay = curr.day;

            maxDays = Math.max(maxDays, currDay);

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                int nextDay = currDay + 1;

                if( nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M && !VISITED[nextRow][nextCol] && STORAGE[nextRow][nextCol] == 0 ) {

                    // 토마토가 익었음
                    STORAGE[nextRow][nextCol] = 1;
                    VISITED[nextRow][nextCol] = true;
                    dq.add(new Node(nextRow, nextCol, nextDay));
                }
            }
        }

        return maxDays;
    }

    static class Node {
        int row;
        int col;
        int day;

        public Node(int row, int col, int day) {
            this.row = row;
            this.col = col;
            this.day = day;
        }
    }
}
