package 바킹독_과제._1주차_BFS.불_5427;

import java.io.*;
import java.util.*;

public class Main_황병수 {

    static int R, C;
    static char[][] map;
    static int[][] fireTime, personTime;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static class Node {
        int y, x, depth;

        Node(int y, int x, int depth) {
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int k = 0; k < testCase; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            map = new char[R][C];
            fireTime = new int[R][C];
            personTime = new int[R][C];

            Queue<Node> fireQ = new ArrayDeque<>();
            Queue<Node> personQ = new ArrayDeque<>();

            for (int i = 0; i < R; i++) {
                String line = br.readLine();
                for (int j = 0; j < C; j++) {
                    map[i][j] = line.charAt(j);
                    fireTime[i][j] = -1;
                    personTime[i][j] = -1;
                    if (map[i][j] == '*') {
                        fireQ.add(new Node(i, j, 0));
                        fireTime[i][j] = 0;
                    }
                    if (map[i][j] == '@') {
                        personQ.add(new Node(i, j, 0));
                        personTime[i][j] = 0;
                    }
                }
            }

            while (!fireQ.isEmpty()) {
                Node cur = fireQ.poll();
                for (int d = 0; d < 4; d++) {
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];
                    if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                    if (map[ny][nx] == '#' || fireTime[ny][nx] != -1) continue;
                    fireTime[ny][nx] = cur.depth + 1;
                    fireQ.add(new Node(ny, nx, cur.depth + 1));
                }
            }

            // 2. 사람 BFS: 불보다 먼저 도달할 수 있는 곳만 이동
            boolean escaped = false;
            while (!personQ.isEmpty()) {
                Node cur = personQ.poll();

                // 탈출 조건: 맵 밖으로 나가면 성공
                if (cur.y == 0 || cur.y == R - 1 || cur.x == 0 || cur.x == C - 1) {
                    sb.append(cur.depth + 1).append('\n');
                    escaped = true;
                    break;
                }

                for (int d = 0; d < 4; d++) {
                    int ny = cur.y + dy[d];
                    int nx = cur.x + dx[d];
                    if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                    if (map[ny][nx] == '#' || personTime[ny][nx] != -1) continue;

                    // 불이 이미 와있거나 동시에 도착하면 이동 불가
                    if (fireTime[ny][nx] != -1 && fireTime[ny][nx] <= cur.depth + 1) continue;

                    personTime[ny][nx] = cur.depth + 1;
                    personQ.add(new Node(ny, nx, cur.depth + 1));
                }
            }
            if (!escaped) {
                sb.append("IMPOSSIBLE").append('\n');
            }
        }

        System.out.println(sb);
    }
}
