package 바킹독_과제._1주차_BFS.불_5427;

import java.io.*;
import java.util.*;

public class Main_홍창모 {

    static int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위

    static int[][] MAP;
    static int[][] fireTime; // 불이 번지는 시간
    static int[][] sangTime; // 상근이가 도착하는 시간

    static int W, H;

    static List<Fire> FIRE_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        for(int t = 0; t < T; t++) {
            FIRE_LIST = new ArrayList<>();
            Node node = null;

            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            MAP = new int[H+2][W+2];
            fireTime = new int[H+2][W+2];
            sangTime = new int[H+2][W+2];

            Arrays.fill(MAP[0], -1);
            Arrays.fill(MAP[H + 1], -1);

            for( int i = 1; i <= H; i++ ) {
                char[] charArray = br.readLine().toCharArray();
                for( int j = 1; j <= W; j++ ) {
                    char c = charArray[j-1];

                    if( c == '#' ) {
                        MAP[i][j] = 1;
                    } else if( c == '*' ) {
                        FIRE_LIST.add(new Fire(i, j));
                        MAP[i][j] = 2;
                    } else if( c == '.' ) {
                        MAP[i][j] = 0;
                    } else if( c == '@' ) {
                        node = new Node(i, j, 0);
                        MAP[i][j] = 0;
                    }
                }
            }

            fireBFS(); // 불의 번진 시간 먼저 계산

            if (!sangBFS(node)) {
                System.out.println("IMPOSSIBLE");
            }
        }
    }

    // 불의 BFS: 각 칸마다 불이 언제 번지는지 기록
    static void fireBFS() {
        Queue<Fire> q = new ArrayDeque<>();
        for (Fire fire : FIRE_LIST) {
            q.add(fire);
            fireTime[fire.row][fire.col] = 1; // 1분부터 시작
        }

        while (!q.isEmpty()) {
            Fire curr = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + dx[i];
                int nextCol = curr.col + dy[i];
                if (nextRow > 0 && nextRow <= H && nextCol > 0 && nextCol <= W) {
                    if (MAP[nextRow][nextCol] == 0 && fireTime[nextRow][nextCol] == 0) {
                        fireTime[nextRow][nextCol] = fireTime[curr.row][curr.col] + 1;
                        q.add(new Fire(nextRow, nextCol));
                    }
                }
            }
        }
    }

    // 상근이의 BFS: 불이 번지기 전에만 이동 가능
    static boolean sangBFS(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        sangTime[node.row][node.col] = 1; // 1분부터 시작

        while (!q.isEmpty()) {
            Node curr = q.poll();

            int currRow = curr.row;
            int currCol = curr.col;
            int currTime = sangTime[currRow][currCol];

            // 탈출 조건: 맵 밖으로 나가면 탈출 성공
            if (currRow <= 0 || currRow > H || currCol <= 0 || currCol > W ) {
                System.out.println(currTime - 1); // 시작이 1이므로 -1
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                // 맵 범위 내, 벽이 아니고, 방문하지 않은 곳
                if (nextRow > 0 && nextRow <= H && nextCol > 0 && nextCol <= W && MAP[nextRow][nextCol] == 0 && sangTime[nextRow][nextCol] == 0) {

                    // 불이 아직 안 왔거나, 상근이가 더 빨리 도착할 때만 이동
                    if (fireTime[nextRow][nextCol] == 0 || currTime + 1 < fireTime[nextRow][nextCol]) {
                        sangTime[nextRow][nextCol] = currTime + 1;
                        q.add(new Node(nextRow, nextCol, 0));
                    }
                }
                // 만약 맵 밖으로 나가는 경우 탈출
                else if (nextRow <= 0 || nextRow > H || nextCol <= 0 || nextCol > W) {
                    System.out.println(currTime);
                    return true;
                }
            }
        }
        return false;
    }

    static class Node {
        int row;
        int col;
        int time;

        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static class Fire {
        int row;
        int col;

        public Fire(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
