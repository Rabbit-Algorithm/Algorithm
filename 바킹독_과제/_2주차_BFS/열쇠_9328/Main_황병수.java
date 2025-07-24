package 바킹독_과제._2주차_BFS.열쇠_9328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_황병수 {
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] hasKey;
    static List<int[]>[] doorList; // 각 문에 대해 대기 중인 위치 리스트

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int k = 0; k < testCase; k++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                map[i] = line.toCharArray();
            }

            hasKey = new boolean[26];
            doorList = new ArrayList[26];

            for (int i = 0; i < 26; i++) doorList[i] = new ArrayList<>();

            String keyLine = br.readLine().trim();
            if (!keyLine.equals("0")) {
                for (char key : keyLine.toCharArray()) {
                    hasKey[key - 'a'] = true;
                }
            }
            int answer = bfs();
            sb.append(answer).append('\n');
        }
        System.out.println(sb);
    }
    static int bfs() {
        Queue<int[]> q = new ArrayDeque<>();
        visited = new boolean[h][w];

        // 가장자리에 있는 입구 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if ((i == 0 || i == h - 1 || j == 0 || j == w - 1) && map[i][j] != '*') {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            char c = map[x][y];

            // 아이템 획득
            if (c == '$') {
                cnt++;
            }

            // 열쇠 획득
            if ('a' <= c && c <= 'z') {
                int keyIdx = c - 'a';
                if (!hasKey[keyIdx]) {
                    hasKey[keyIdx] = true;
                    // 이 열쇠로 열 수 있는 문 위치들 다시 큐에 넣기
                    for (int[] pos : doorList[keyIdx]) {
                        q.offer(pos);
                    }
                }
            }

            // 문 만남
            if ('A' <= c && c <= 'Z') {
                int doorIdx = c - 'A';
                if (!hasKey[doorIdx]) {
                    doorList[doorIdx].add(new int[]{x, y});
                    continue; // 아직 못 들어감
                }
            }

            // 4방향 이동
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == '*') continue;
                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
        return cnt;
    }
}
