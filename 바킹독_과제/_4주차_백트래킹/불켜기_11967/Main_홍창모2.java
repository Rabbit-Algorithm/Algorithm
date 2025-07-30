package _4주차_백트래킹.불켜기_11967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모2 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] BOARD; // 0: 불 켜짐, 1: 불 꺼짐
    static boolean[][] VISITED;
    static int N, M, COUNT;
    static List<Node>[][] SWITCHES;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BOARD = new int[N+1][N+1];
        VISITED = new boolean[N+1][N+1];
        SWITCHES = new ArrayList[N+1][N+1];

        for( int i = 1; i <= N; i++ ) {
            // 처음엔 모두 불 꺼짐으로 초기화
            Arrays.fill(BOARD[i], 1);
            for( int j = 1; j <= N; j++ ) {
                SWITCHES[i][j] = new ArrayList<>();
            }
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 불을 켤 수 있는 방의 위치 저장
            SWITCHES[x][y].add(new Node(a,b));
        }

        // (1,1)은 처음 방문 가능한 상태
        BOARD[1][1] = 0;
        VISITED[1][1] = true;
        COUNT = 1;

        BFS();

        System.out.println(COUNT);
    }

    private static void BFS() {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(1,1));

        while (!dq.isEmpty()) {
            Node curr = dq.poll();

            int currRow = curr.row;
            int currCol = curr.col;

            for( Node switches : SWITCHES[currRow][currCol] ) {
                int connectRow = switches.row;
                int connectCol = switches.col;

                if( BOARD[connectRow][connectCol] == 1 ) {
                    // 불꺼진 방이면 불키도록 처리
                    BOARD[connectRow][connectCol] = 0;
                    COUNT++;

                    for( int i = 0; i < 4; i++ ) {
                        int nextRow = connectRow + dx[i];
                        int nextCol = connectCol + dy[i];

                        if( nextRow >= 1 && nextCol >= 1 && nextRow <= N && nextCol <= N ) {
                            if( VISITED[nextRow][nextCol] ) {
                                dq.add(new Node(connectRow, connectCol));
                                VISITED[connectRow][connectCol] = true;
                                break;
                            }
                        }
                    }
                }
            }

            for( int i = 0; i < 4; i++ ) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                if( nextRow >= 1 && nextCol >= 1 && nextRow <= N && nextCol <= N && !VISITED[nextRow][nextCol] ) {
                    if( BOARD[nextRow][nextCol] == 0 ) {
                        dq.add(new Node(nextRow, nextCol));
                        VISITED[nextRow][nextCol] = true;
                    }
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
