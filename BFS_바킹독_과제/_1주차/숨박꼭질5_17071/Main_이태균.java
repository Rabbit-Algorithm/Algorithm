package BFS_바킹독_과제._1주차.숨박꼭질5_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int N;
    private static int K;
    private static boolean[][] VISITED = new boolean[500001][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0, K));
        VISITED[N][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now_pos = node.pos;
            int now_time = node.time;
            int now_dest = node.dest;

            if (now_dest > 500_000) {
                break;
            }
            if (VISITED[now_dest][now_time % 2]) {
                return now_time;
            }

            int[] cal = {now_pos * 2, now_pos + 1, now_pos - 1};
            for (int next_pos : cal) {
                if (next_pos >= 0 && next_pos <= 500_000 && !VISITED[next_pos][(now_time + 1) % 2]) {
                    queue.offer(new Node(next_pos, now_time + 1, now_dest));
                    VISITED[next_pos][(now_time + 1) % 2] = true;
                }
            }
        }

        return -1;
    }

    static class Node {
        int pos;
        int time;
        int dest;

        public Node(int pos, int time, int dest) {
            this.pos = pos;
            this.time = time;
            this.dest = dest + time;
        }
    }

}