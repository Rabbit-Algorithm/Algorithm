package 숨박꼭질4_13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 경로 복원 숨바꼭질
 */
public class Main_이태균 {

    private static int N;
    private static int K;
    private static boolean[] VISITED = new boolean[100001];
    private static int[] FROM = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(bfs());

        Stack<Integer> path = new Stack<>();
        for (int i = K; i != N; i = FROM[i]) {
            path.push(i);
        }
        path.push(N);

        StringBuilder sb = new StringBuilder();
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" ");
        }
        System.out.println(sb);
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
                queue.add(new Node(now_pos * 2, now_time + 1));
                VISITED[now_pos * 2] = true;
                FROM[now_pos * 2] = now_pos;
            }
            if (now_pos - 1 >= 0 && !VISITED[now_pos - 1]) {
                queue.add(new Node(now_pos - 1, now_time + 1));
                VISITED[now_pos - 1] = true;
                FROM[now_pos - 1] = now_pos;
            }
            if (now_pos + 1 <= 100000 && !VISITED[now_pos + 1]) {
                queue.add(new Node(now_pos + 1, now_time + 1));
                VISITED[now_pos + 1] = true;
                FROM[now_pos + 1] = now_pos;
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
