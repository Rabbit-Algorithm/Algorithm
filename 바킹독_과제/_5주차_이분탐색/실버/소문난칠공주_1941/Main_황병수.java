package 바킹독_과제._5주차_이분탐색.실버.소문난칠공주_1941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main_황병수 {
    static char[][] board = new char[5][5];
    static boolean[] visited = new boolean[25];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            String line = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        combination(0, 0, 0);
        System.out.println(result);
    }

    static void combination(int idx, int count, int sCount) {
        // 7명 다 선택했을 때
        if (count == 7) {
            // S가 4명 이상이고 연결되어 있으면 카운트
            if (sCount >= 4 && isConnected()) {
                result++;
            }
            return;
        }

        // 가지치기: 남은 자리로는 7명을 못 채우는 경우
        if (idx == 25) return;
        if (count + (25 - idx) < 7) return;

        // 현재 위치 선택하는 경우
        visited[idx] = true;
        int x = idx / 5;
        int y = idx % 5;

        combination(idx + 1, count + 1, sCount + (board[x][y] == 'S' ? 1 : 0));

        // 현재 위치 선택하지 않는 경우
        visited[idx] = false;
        combination(idx + 1, count, sCount);
    }

    static boolean isConnected() {
        // 선택된 첫 번째 위치 찾기
        int start = -1;
        for (int i = 0; i < 25; i++) {
            if (visited[i]) {
                start = i;
                break;
            }
        }

        // BFS로 연결된 것들 체크
        boolean[] check = new boolean[25];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        check[start] = true;
        int connected = 1;

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            int x = curr / 5, y = curr % 5;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                    int next = nx * 5 + ny;
                    // 방문했고(선택된 위치) + BFS에서 아직 안 본 곳
                    if (visited[next] && !check[next]) {
                        check[next] = true;
                        queue.add(next);
                        connected++;
                    }
                }
            }
        }

        return connected == 7;
    }
}
