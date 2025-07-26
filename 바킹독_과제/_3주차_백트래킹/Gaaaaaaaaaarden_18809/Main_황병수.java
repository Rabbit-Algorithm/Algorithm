package 바킹독_과제._3주차_백트래킹.Gaaaaaaaaaarden_18809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_황병수 {
    static int N, M, GREEN, RED;
    static int[][] map;
    static List<int[]> candidates = new ArrayList<>();
    static int maxFlowers = 0;
    static int[] selectedPositions;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        GREEN = Integer.parseInt(st.nextToken());
        RED = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) candidates.add(new int[]{i, j});
            }
        }

        selectedPositions = new int[GREEN + RED];
        choosePositions(0, 0);
        System.out.println(maxFlowers);
    }

    // 후보지 중 GREEN+RED 개 위치 선택
    static void choosePositions(int start, int depth) {
        if (depth == GREEN + RED) {
            // 선택된 위치들에 대해 초록/빨강 배치 조합 탐색
            int[] colorAssign = new int[GREEN + RED]; // 0: 초록, 1: 빨강
            assignColors(0, 0, 0, colorAssign);
            return;
        }

        for (int i = start; i < candidates.size(); i++) {
            selectedPositions[depth] = i;
            choosePositions(i + 1, depth + 1);
        }
    }

    // 선택된 위치들에 GREEN 만큼 초록, RED 만큼 빨강 할당 모든 경우 탐색
    static void assignColors(int depth, int greenCount, int redCount, int[] colorAssign) {
        if (depth == GREEN + RED) {
            // 시뮬레이션
            bfsSimulation(colorAssign);
            return;
        }

        if (greenCount < GREEN) {
            colorAssign[depth] = 0; // 초록
            assignColors(depth + 1, greenCount + 1, redCount, colorAssign);
        }
        if (redCount < RED) {
            colorAssign[depth] = 1; // 빨강
            assignColors(depth + 1, greenCount, redCount + 1, colorAssign);
        }
    }

    // BFS 시뮬레이션으로 꽃 개수 계산
    static void bfsSimulation(int[] colorAssign) {
        int[][] state = new int[N][M]; // 0: 빈 칸, -1: 배양 불가능, 1: 초록, 2: 빨강, 3: 꽃
        int[][] time = new int[N][M];  // 배양액 도달 시간 기록

        for (int i = 0; i < N; i++) {
            Arrays.fill(state[i], 0);
            Arrays.fill(time[i], -1);
        }

        Queue<Node> q = new ArrayDeque<>();
        for (int i = 0; i < selectedPositions.length; i++) {
            int idx = selectedPositions[i];
            int r = candidates.get(idx)[0];
            int c = candidates.get(idx)[1];

            int color = colorAssign[i] == 0 ? 1 : 2; // 1: 초록, 2: 빨강
            state[r][c] = color;
            time[r][c] = 0;
            q.add(new Node(r, c, color, 0));
        }

        int flowers = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 꽃이 핀 위치는 더 이상 확산 안됨
            if (state[cur.r][cur.c] == 3) continue;

            for (int dir = 0; dir < 4; dir++) {
                int nr = cur.r + dr[dir];
                int nc = cur.c + dc[dir];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (map[nr][nc] == 0) continue; // 배양 불가능 자리
                if (state[nr][nc] == 3) continue; // 이미 꽃 핀 자리

                if (state[nr][nc] == 0) {
                    // 아직 도달 안한 자리 -> 배양액 도달
                    state[nr][nc] = cur.color;
                    time[nr][nc] = cur.time + 1;
                    q.add(new Node(nr, nc, cur.color, cur.time + 1));
                } else if ((state[nr][nc] == 1 || state[nr][nc] == 2) && state[nr][nc] != cur.color && time[nr][nc] == cur.time + 1) {
                    // 초록, 빨강 서로 다른 배양액이 동시에 도달 -> 꽃 피어남
                    flowers++;
                    state[nr][nc] = 3; // 꽃 표시
                }
            }
        }

        maxFlowers = Math.max(maxFlowers, flowers);
    }

    static class Node {
        int r, c, color, time;

        Node(int r, int c, int color, int time) {
            this.r = r;
            this.c = c;
            this.color = color;
            this.time = time;
        }
    }
}