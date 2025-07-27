package 바킹독_과제._3주차_백트래킹.Gaaaaaaaaaarden_18809;

import java.io.*;
import java.util.*;

public class Main_홍창모 {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, G, R;
    static int[][] FIELD;
    static List<Node> POSSIBLE_FIELD;
    static int totalFloweringCount = 0; // 최대 꽃 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        FIELD = new int[N][M];
        POSSIBLE_FIELD = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                FIELD[i][j] = Integer.parseInt(st.nextToken());
                if (FIELD[i][j] == 2)
                    POSSIBLE_FIELD.add(new Node(i, j));
            }
        }

        int[] RANDOM_CULTURE = new int[G + R]; // 뽑은 인덱스 조합

        combinationCulture(0, 0, RANDOM_CULTURE);

        System.out.println(totalFloweringCount);
    }

    // candidate 인덱스에서 G+R개를 골라 culture에 기록 (조합)
    static void combinationCulture(int depth, int idx, int[] RANDOM_CULTURE) {
        if (depth == G + R) {
            // 배양액 색 배분
            boolean[] isGreen = new boolean[G + R];
            combinationGreen(0, 0, isGreen, RANDOM_CULTURE);
            return;
        }
        if (idx == POSSIBLE_FIELD.size()) return;

        // 선택
        RANDOM_CULTURE[depth] = idx;
        combinationCulture(depth + 1, idx + 1, RANDOM_CULTURE);
        // 미선택
        combinationCulture(depth, idx + 1, RANDOM_CULTURE);
    }

    // Culture에서 G개를 green으로, 나머지 R개는 red로 나눠 isGreen에 표시
    static void combinationGreen(int depth, int idx, boolean[] isGreen, int[] RANDOM_CULTURE) {
        if (depth == G) {
            totalFloweringCount = Math.max(totalFloweringCount, bfs(RANDOM_CULTURE, isGreen));
            return;
        }
        if (idx == isGreen.length) return;
        // 선택(현재를 green)
        isGreen[idx] = true;
        combinationGreen(depth + 1, idx + 1, isGreen, RANDOM_CULTURE);
        // 미선택(back)
        isGreen[idx] = false;
        combinationGreen(depth, idx + 1, isGreen, RANDOM_CULTURE);
    }

    // BFS에서 배양액 퍼뜨리며 꽃 개수 셈
    static int bfs(int[] RANDOM_CULTURE, boolean[] isGreen) {
        int[][] visitTime = new int[N][M]; // 방문 시간
        int[][] visitColor = new int[N][M]; // 0:없음, 1:green, 2:red, 3:flower
        Queue<Flower> q = new LinkedList<>();

        for (int i = 0; i < G + R; i++) {
            Node curr = POSSIBLE_FIELD.get(RANDOM_CULTURE[i]);
            if (isGreen[i]) {
                visitTime[curr.row][curr.col] = 0;
                visitColor[curr.row][curr.col] = 1;
                q.add(new Flower(curr.row, curr.col, 'G', 0, false));
            } else {
                visitTime[curr.row][curr.col] = 0;
                visitColor[curr.row][curr.col] = 2;
                q.add(new Flower(curr.row, curr.col, 'R', 0, false));
            }
        }

        int flowerCount = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            List<Flower> currentStep = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                currentStep.add(q.poll());
            }
            for (Flower cur : currentStep) {
                if (visitColor[cur.row][cur.col] == 3) continue;
                for (int d = 0; d < 4; d++) {
                    int nx = cur.row + dx[d];
                    int ny = cur.col + dy[d];
                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (FIELD[nx][ny] == 0) continue; // 호수
                    if (visitColor[nx][ny] == 0) {
                        visitTime[nx][ny] = cur.time + 1;
                        visitColor[nx][ny] = (cur.color == 'G' ? 1 : 2);
                        q.add(new Flower(nx, ny, cur.color, cur.time + 1, false));
                    }
                    // 이미 다른 색 배양액이 같은 시간에 도착한 경우(꽃)
                    else if ( visitColor[nx][ny] != 3 && visitColor[nx][ny] != (cur.color == 'G' ? 1 : 2) && visitTime[nx][ny] == cur.time + 1) {
                        visitColor[nx][ny] = 3;
                        flowerCount++;
                    }
                }
            }
        }
        return flowerCount;
    }

    static class Node {
        int row, col;
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Flower {
        int row, col, time;
        char color;
        boolean isFlowering;
        public Flower(int row, int col, char color, int time, boolean isFlowering) {
            this.row = row;
            this.col = col;
            this.color = color;
            this.time = time;
            this.isFlowering = isFlowering;
        }
    }
}
