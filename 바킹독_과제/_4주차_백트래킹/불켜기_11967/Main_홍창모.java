package _4주차_백트래킹.불켜기_11967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 처음 풀이는 현재 방에 연결된 불을 킬 수 있는 방의 좌표를
 * List<Node> CONNECT_LIST 를 선언하여 풀이하였음.
 *
 * 예제 코드는 성공했으나, 코드 제출시 시간 초과 발생
 * 이유 : 방의 개수가 많아질수록 한번에 불 켜는 대상 전체를 리니어하게 탐색하기 때문에, 방의 개수가 많아질수록 느려져 시간 초과가 발생하는 것 같음....ㅠ
 *
 * List<Node>[][] 형식으로 변경하여 풀이 변경 > Main_홍창모2.java로
 * */

public class Main_홍창모 {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] BOARD;
    static boolean[][] VISITED, TURN_ON_LIGHT;
    static int N, M, COUNT;
    static List<Node> CONNECT_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        BOARD = new int[N+1][N+1];
        VISITED = new boolean[N+1][N+1];
        TURN_ON_LIGHT = new boolean[N+1][N+1];

        // 모든 방 불 꺼짐(1)으로 초기화
        for(int i=1; i<=N; i++) {
            Arrays.fill(BOARD[i], 1);
        }
        // 시작 지점 불 켜짐(0)
        BOARD[1][1] = 0;

        CONNECT_LIST = new ArrayList<>();
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            CONNECT_LIST.add(new Node(x, y, new Node(a, b, null)));
        }

        // (1,1)은 처음 방문 가능한 상태
        VISITED[1][1] = true;
        COUNT = 1;

        // 불이 켜지거나 방문이 확장되는 동안 반복
        BFS();

        System.out.println(COUNT);
    }

    private static void BFS() {
        boolean changed;
        do {
            changed = false;
            Deque<Node> dq = new ArrayDeque<>();

            // 이미 방문한 방들을 모두 큐에 넣고 한번씩 BFS 돌림
            for(int i=1; i<=N; i++) {
                for(int j=1; j<=N; j++) {
                    if(BOARD[i][j] == 0 && VISITED[i][j]) {
                        dq.offer(new Node(i, j, null));
                    }
                }
            }

            // BFS 탐색
            boolean[][] visitedInThisLoop = new boolean[N+1][N+1];
            while(!dq.isEmpty()) {
                Node curr = dq.poll();
                int r = curr.row;
                int c = curr.col;

                // 이미 이 루프 내 방문했다면 continue
                if(visitedInThisLoop[r][c]) continue;
                visitedInThisLoop[r][c] = true;

                // 이 방에서 누를 수 있는 스위치 모두 작동
                for(Node n : CONNECT_LIST) {
                    if(n.row == r && n.col == c) {
                        Node target = n.connect;
                        int tr = target.row;
                        int tc = target.col;
                        if(BOARD[tr][tc] == 1) {
                            BOARD[tr][tc] = 0; // 불 켬
                            COUNT++;
                            changed = true;
                        }
                    }
                }

                // 4방향 탐색하여 방문 확장
                for(int i=0; i<4; i++) {
                    int nextRow = r + dx[i];
                    int nextCol = c + dy[i];
                    if(nextRow >= 1 && nextRow <= N && nextCol >=1 && nextCol <= N) {
                        if(BOARD[nextRow][nextCol] == 0 && !VISITED[nextRow][nextCol]) {
                            VISITED[nextRow][nextCol] = true;
                            changed = true;
                            dq.offer(new Node(nextRow, nextCol, null));
                        }
                    }
                }
            }

        } while(changed);
    }

    static class Node {
        int row, col;
        Node connect;

        public Node(int row, int col, Node connect) {
            this.row = row;
            this.col = col;
            this.connect = connect;
        }
    }
}
