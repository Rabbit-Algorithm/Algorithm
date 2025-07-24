package 바킹독_과제._2주차_BFS.벽부수고이동하기3_16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_홍창모 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, K;
    static int[][] MAP;
    static boolean[][][] VISITED;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 부술 수 있는 벽의 개수
        K = Integer.parseInt(st.nextToken());

        MAP = new int[N][M];
        VISITED = new boolean[N][M][K+1];

        for( int i = 0; i < N; i++ ) {
            char[] charArr = br.readLine().toCharArray();
            for( int j = 0; j < M; j++ ) {
                MAP[i][j] = charArr[j] - '0';
            }
        }

        if( !BFS() ) {
            System.out.println(-1);
        }
    }

    static boolean BFS() {
        Deque<Node> dq = new ArrayDeque<>();

        dq.add(new Node(0, 0, 0, 0, false));
        // 4번째 배열의 요소 0이 낮이고 1이 밤이다.
        VISITED[0][0][0] = true;

        while (!dq.isEmpty()) {
            Node curr = dq.poll();

            int currRow = curr.row;
            int currCol = curr.col;
            int currTime = curr.time;
            int currBroken = curr.broken;

            boolean currIsNight = curr.isNight;

            if( currRow == N-1 && currCol == M-1 ) {
                System.out.println(currTime + 1);
                return true;
            }

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];
                int nextBroken = currBroken + 1;

                if( nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M ) {
                    if( currIsNight ) {
                        // 밤이면
                        if( MAP[nextRow][nextCol] == 1 && nextBroken <= K && !VISITED[nextRow][nextCol][nextBroken] ) {
                            dq.add(new Node(currRow, currCol, currTime + 1, currBroken, false));
                            VISITED[currRow][currCol][currBroken] = true;
                        } else if( MAP[nextRow][nextCol] == 0 && !VISITED[nextRow][nextCol][currBroken] ) {
                            dq.add(new Node(nextRow, nextCol, currTime + 1, currBroken, false));
                            VISITED[nextRow][nextCol][currBroken] = true;
                        }

                    } else {
                        // 낮이면
                        if( MAP[nextRow][nextCol] == 1 && nextBroken <= K && !VISITED[nextRow][nextCol][nextBroken] ) {
                            dq.add(new Node(nextRow, nextCol, currTime + 1, nextBroken, true));
                            VISITED[nextRow][nextCol][nextBroken] = true;
                        } else if( MAP[nextRow][nextCol] == 0 && !VISITED[nextRow][nextCol][currBroken] ) {
                            dq.add(new Node(nextRow, nextCol, currTime + 1, currBroken, true));
                            VISITED[nextRow][nextCol][currBroken] = true;
                        }
                    }

                }

            }
        }

        return false;
    }

    static class Node {
        int row, col, time, broken;
        boolean isNight;
        public Node(int row, int col, int time, int broken, boolean isNight) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.broken = broken;
            this.isNight = isNight;
        }
    }
}
