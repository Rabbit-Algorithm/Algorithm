package 바킹독_과제._1주차_BFS.숨박꼭질3_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 가중치가 0 또는 1인 간선을 가진 그래프이므로 BFS -> 0-1 BFS
 */
public class Main_이태균_BFS {

    private static int N;
    private static int K;
    private static boolean[] VISITED = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        VISITED[N] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int now_pos = node.pos;
            int now_time = node.time;

            if (now_pos == K) {
                return now_time;
            }

            if (now_pos * 2 <= 100000 && !VISITED[now_pos * 2]) {
                queue.add(new Node(now_pos * 2, now_time));
                VISITED[now_pos * 2] = true;
            }
            if (now_pos - 1 >= 0 && !VISITED[now_pos - 1]) {
                queue.add(new Node(now_pos - 1, now_time + 1));
                VISITED[now_pos - 1] = true;
            }
            if (now_pos + 1 <= 100000 && !VISITED[now_pos + 1]) {
                queue.add(new Node(now_pos + 1, now_time + 1));
                VISITED[now_pos + 1] = true;
            }
        }

        return -1;
    }

    static class Node {
        int pos;
        int time;

        public Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

}
