package BFS_바킹독_과제._1주차.불_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int W;
    private static int H;
    private static char[][] MAP;
    private static int[] DX = {-1, 0, 1, 0};
    private static int[] DY = {0, -1, 0, 1};
    private static Queue<Node> NODE_LIST = new LinkedList<>();
    private static Queue<Fire> FIRE_LIST = new LinkedList<>();
    private static boolean[][] NODE_VISITED;
    private static boolean[][] FIRE_VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        MAP = new char[H][W];
        NODE_VISITED = new boolean[H][W];
        FIRE_VISITED = new boolean[H][W];

        for (int row = 0; row < H; row++) {
            char[] str = br.readLine().toCharArray();
            for (int col = 0; col < W; col++) {
                if (str[col] == 'J') {
                    NODE_LIST.add(new Node(row, col, 0));
                    NODE_VISITED[row][col] = true;

                    if (row == 0 || col == 0 || row == H - 1 || col == W - 1) {
                        System.out.println(1);
                        return;
                    }

                    str[col] = '.';
                }
                if (str[col] == 'F') {
                    FIRE_LIST.add(new Fire(row, col));
                    FIRE_VISITED[row][col] = true;
                }
                MAP[row][col] = str[col];
            }
        }

        bfs();
    }

    private static void bfs() {
        while (!NODE_LIST.isEmpty()) {
            int fireSize = FIRE_LIST.size();
            for (int f = 0; f < fireSize; f++) {
                Fire fire = FIRE_LIST.poll();
                for (int i = 0; i < 4; i++) {
                    int next_row = fire.row + DX[i];
                    int next_col = fire.col + DY[i];

                    if (next_row >= 0 && next_col >= 0 && next_row < H && next_col < W) {
                        if (!FIRE_VISITED[next_row][next_col] && MAP[next_row][next_col] == '.') {
                            FIRE_VISITED[next_row][next_col] = true;
                            MAP[next_row][next_col] = '*';
                            FIRE_LIST.add(new Fire(next_row, next_col));
                        }
                    }
                }
            }

            int nodeSize = NODE_LIST.size();
            for (int n = 0; n < nodeSize; n++) {
                Node node = NODE_LIST.poll();
                int now_row = node.row;
                int now_col = node.col;
                int now_time = node.time;

                if (now_row == 0 || now_col == 0 || now_row == H - 1 || now_col == W - 1) {
                    System.out.println(now_time + 1);
                    return;
                }

                for (int i = 0; i < 4; i++) {
                    int next_row = now_row + DX[i];
                    int next_col = now_col + DY[i];

                    if (next_row >= 0 && next_col >= 0 && next_row < H && next_col < W) {
                        if (!NODE_VISITED[next_row][next_col] && MAP[next_row][next_col] == '.') {
                            NODE_VISITED[next_row][next_col] = true;
                            NODE_LIST.add(new Node(next_row, next_col, now_time + 1));
                        }
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
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
