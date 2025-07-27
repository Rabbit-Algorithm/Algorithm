import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_이태균 {

    private static int N, M, G, R;
    private static int[][] GARDEN; // 0 : 호수, 1 : 일반 땅, 2 : 배양 가능
    private static int[] DX = {-1, 0, 1, 0};
    private static int[] DY = {0, -1, 0, 1};
    private static List<Node> AVALIABLE = new ArrayList<>();
    private static int MAX_FLOWERS = 0;
    private static int[] GREEN_SEED;
    private static int[] RED_SEED;
    private static boolean[] USED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        GARDEN = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                GARDEN[i][j] = Integer.parseInt(st.nextToken());
                if (GARDEN[i][j] == 2) {
                    AVALIABLE.add(new Node(i, j));
                }
            }
        }

        GREEN_SEED = new int[G];
        RED_SEED = new int[R];
        USED = new boolean[AVALIABLE.size()];

        selectGreen(0, 0);

        System.out.println(MAX_FLOWERS);
    }

    // 초록 씨앗 조합 뽑기
    static void selectGreen(int start, int depth) {
        if (depth == G) {
            selectRed(0, 0);
            return;
        }

        for (int i = start; i < AVALIABLE.size(); i++) {
            if (!USED[i]) { // 겹치지 않는 위치만 선택
                USED[i] = true;
                GREEN_SEED[depth] = i;
                selectGreen(i + 1, depth + 1);
                USED[i] = false;
            }
        }
    }

    // 빨강 씨앗 조합 뽑기
    static void selectRed(int start, int depth) {
        if (depth == R) { // // 빨강 씨앗 모두 선택했으면 -> 시뮬레이션 실행
            simulate();
            return;
        }
        for (int i = start; i < AVALIABLE.size(); i++) {
            if (!USED[i]) { // 겹치지 않는 위치만 선택
                USED[i] = true;
                RED_SEED[depth] = i;
                selectRed(i + 1, depth + 1);
                USED[i] = false;
            }
        }
    }

    // BFS 시뮬레이션
    static void simulate() {
        int[][] visitTime = new int[N][M]; // 각 위치 방문 시간 기록
        int[][] colorMap = new int[N][M]; // 0 : 방문 안함, 1 : 초록 도달, 2 : 빨강 도달, 3 : 꽃 피움

        for (int i = 0; i < N; i++) {
            Arrays.fill(visitTime[i], -1);
            Arrays.fill(colorMap[i], 0);
        }

        Queue<Seed> queue = new LinkedList<>();

        // 씨앗 좌표들 큐에 넣기
        for (int i = 0; i < G; i++) {
            Node node = AVALIABLE.get(GREEN_SEED[i]);
            int now_row = node.row;
            int now_col = node.col;

            queue.offer(new Seed(now_row, now_col, 0, 1));  // 1: 초록색
            visitTime[now_row][now_col] = 0;
            colorMap[now_row][now_col] = 1;
        }

        for (int i = 0; i < R; i++) {
            Node node = AVALIABLE.get(RED_SEED[i]);
            int now_row = node.row;
            int now_col = node.col;

            queue.offer(new Seed(now_row, now_col, 0, 2));  // 2: 빨간색
            visitTime[now_row][now_col] = 0;
            colorMap[now_row][now_col] = 2;
        }

        int flowers = 0;

        while (!queue.isEmpty()) {
            Seed seed = queue.poll();
            int seed_row = seed.row;
            int seed_col = seed.col;

            if (colorMap[seed_row][seed_col] == 3) {
                continue; // 꽃 핀 자리 확산 안함
            }

            for (int d = 0; d < 4; d++) {
                int next_row = seed_row + DX[d];
                int next_col = seed_col + DY[d];

                if (GARDEN[next_row][next_col] == 0) {  // 호수
                    continue;
                }
                if (colorMap[next_row][next_col] == 3) { // 꽃 핀 자리
                    continue;
                }

                if (next_row < 0 || next_row >= N || next_col < 0 || next_col >= M) {
                    if (visitTime[next_row][next_col] == -1) {
                        visitTime[next_row][next_col] = seed.time + 1;
                        colorMap[next_row][next_col] = seed.color;
                        queue.offer(new Seed(next_row, next_col, seed.time + 1, seed.color));
                    } else if (visitTime[next_row][next_col] == seed.time + 1 && colorMap[next_row][next_col] != seed.color) {
                        // 동시에 초록, 빨강이 도착하면 꽃 핌
                        flowers++;
                        colorMap[next_row][next_col] = 3;
                    }
                }
            }
        }

        MAX_FLOWERS = Math.max(MAX_FLOWERS, flowers);
    }

    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Seed {
        int row;
        int col;
        int time;
        int color;

        public Seed(int row, int col, int time, int color) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.color = color;
        }
    }
}
