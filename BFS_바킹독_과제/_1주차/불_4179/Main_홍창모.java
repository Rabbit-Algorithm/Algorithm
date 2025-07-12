package 불_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {

    static int[] dx = {1, 0, -1, 0}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int R, C;

    static int[][] MAP;
    static int[][] fireTime; // 불이 번지는 시간
    static int[][] jTime; // 지훈이가 도착하는 시간
    static List<Fire> FIRE_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        MAP = new int[R+2][C+2];
        fireTime = new int[R+2][C+2];
        jTime = new int[R+2][C+2];

        Arrays.fill(MAP[0], -1);
        Arrays.fill(MAP[R + 1], -1);

        FIRE_LIST = new ArrayList<>();
        Node node = null;

        for( int i = 1; i <= R; i++ ) {
            char[] charArray = br.readLine().toCharArray();
            for( int j = 1; j <= C; j++ ) {
                char c = charArray[j-1];

                if( c == '#' ) {
                    MAP[i][j] = 1;
                } else if( c == 'F' ) {
                    FIRE_LIST.add(new Fire(i, j));
                    MAP[i][j] = 2;
                } else if( c == '.' ) {
                    MAP[i][j] = 0;
                } else if( c == 'J' ) {
                    node = new Node(i, j, 0);
                    MAP[i][j] = 0;
                }
            }
        }

        // 불 붙여 버리고
        fireBFS();

        if (!jBFS(node)) {
            System.out.println("IMPOSSIBLE");
        }
    }

    static boolean jBFS(Node node) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);

        jTime[node.row][node.col] = 1; // 1분으로

        while (!q.isEmpty()) {
            Node curr = q.poll();

            int currRow = curr.row;
            int currCol = curr.col;
            int currTime = jTime[currRow][currCol];

            // 탈출 조건: 맵 밖으로 나가면 탈출 성공
            if (currRow <= 0 || currRow > R || currCol <= 0 || currCol > C ) {
                System.out.println(currTime - 1); // 시작이 1이므로 -1
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = currRow + dx[i];
                int nextCol = currCol + dy[i];

                // 맵 범위 내, 벽이 아니고, 방문하지 않은 곳
                if (nextRow > 0 && nextRow <= R && nextCol > 0 && nextCol <= C && MAP[nextRow][nextCol] == 0 && jTime[nextRow][nextCol] == 0) {

                    // 불이 아직 안 왔거나, 상근이가 더 빨리 도착할 때만 이동
                    if (fireTime[nextRow][nextCol] == 0 || currTime + 1 < fireTime[nextRow][nextCol]) {
                        jTime[nextRow][nextCol] = currTime + 1;
                        q.add(new Node(nextRow, nextCol, 0));
                    }
                }
                // 만약 맵 밖으로 나가는 경우 탈출
                else if (nextRow <= 0 || nextRow > R || nextCol <= 0 || nextCol > C) {
                    System.out.println(currTime);
                    return true;
                }
            }

        }

        return false;
    }

    static void fireBFS() {
        Queue<Fire> q = new ArrayDeque<>();

        // 불이 여러개일 경우도 있기 때문에
        for( Fire fire : FIRE_LIST ) {
            q.add(fire);
            fireTime[fire.row][fire.col] = 1; // 1분으로 처리
        }

        while (!q.isEmpty()) {
            Fire curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextRow = curr.row + dx[i];
                int nextCol = curr.col + dy[i];

                if (nextRow > 0 && nextRow <= R && nextCol > 0 && nextCol <=C) {
                    if( MAP[nextRow][nextCol] == 0 && fireTime[nextRow][nextCol] == 0 ) {
                        // 다음으로 이동되는 곳이 지나갈 수 있고, 불이 붙지 않은 공간인 경우에만
                        fireTime[nextRow][nextCol] = fireTime[curr.row][curr.col] + 1;
                        q.add(new Fire(nextRow, nextCol));
                    }
                }
            }
        }
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
