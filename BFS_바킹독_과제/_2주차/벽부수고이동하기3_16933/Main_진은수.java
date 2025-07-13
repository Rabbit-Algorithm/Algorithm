package BFS_바킹독_과제._2주차.벽부수고이동하기3_16933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_진은수 {

    private static int[][] map;
    private static boolean[][][] visited;
    private static int ySize;
    private static int xSize;
    private static int brokenNum;
    private static int length = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ySize = Integer.parseInt(st.nextToken());
        xSize = Integer.parseInt(st.nextToken());
        brokenNum = Integer.parseInt(st.nextToken());

        map = new int[ySize][xSize];
        visited = new boolean[ySize][xSize][brokenNum+1];

        for (int y = 0; y < ySize; y++) {
            String str = br.readLine();
            for (int x = 0; x < xSize; x++) {
                map[y][x] = str.charAt(x) - '0';
            }
        }

        bfs();

        System.out.println(length);
    }

    private static void bfs() {

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, 0, true));
        visited[0][0][0] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1,};

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (now.x == xSize - 1 && now.y == ySize - 1) {
                length = now.depth;
                break;
            }


            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx >= 0 && nx < xSize && ny >= 0 && ny < ySize) {

                    if (map[ny][nx] == 0 && !visited[ny][nx][now.brokenCount] && now.brokenCount >= 0 && now.brokenCount <= brokenNum) {
                        visited[ny][nx][now.brokenCount] = true;
                        queue.add(new Node(nx, ny, now.depth + 1, now.brokenCount, !now.isDay));
                    }
                    if (map[ny][nx] == 1 && !visited[ny][nx][now.brokenCount] && now.brokenCount >= 0 && now.brokenCount < brokenNum && now.isDay) {
                        visited[ny][nx][now.brokenCount] = true;
                        queue.add(new Node(nx, ny, now.depth + 1, now.brokenCount+1, !now.isDay));
                    }

                    if (map[ny][nx] == 1 && !visited[ny][nx][now.brokenCount] && now.brokenCount >= 0 && now.brokenCount < brokenNum && !now.isDay) {
                        queue.add(new Node(now.x, now.y, now.depth + 1, now.brokenCount, !now.isDay));
                    }


                }
            }

        }


    }


    private static class Node {

        int x;
        int y;
        int depth;
        int brokenCount;
        boolean isDay;

        public Node(int x, int y, int depth, int brokenCount, boolean isDay) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.brokenCount = brokenCount;
            this.isDay = isDay;
        }

    }

}