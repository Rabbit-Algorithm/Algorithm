package 숨박꼭질4_13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_황병수 {

    static int[] parent;
    static int max = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        parent = new int[max + 1];    // 0~100000
        Arrays.fill(parent, -1);
        parent[N] = N;

        bfs(N, K);
        printPath(N, K);
    }

    private static void bfs(int N, int K) {
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int pos = poll.pos;
            int sec = poll.sec;

            // 동생을 찾으면 출력 후 종료
            if (pos == K) {
                System.out.println(sec);
                return;
            }

            int[] next = {pos - 1, pos + 1, pos * 2};
            for (int npos : next) {
                if (npos >= 0 && npos <= max && parent[npos] == -1) {
                    parent[npos] = pos;
                    queue.add(new Node(npos, sec + 1));
                }
            }
        }
    }

    private static void printPath(int N, int K) {
        List<Integer> path = new ArrayList<>();
        int cur = K;
        while (cur != N) {
            path.add(cur);
            cur = parent[cur];
        }
        path.add(N);
        Collections.reverse(path);
        for (int p : path) {
            System.out.print(p + " ");
        }
        System.out.println();
    }

    public static class Node {
        int pos;
        int sec;

        public Node(int pos, int sec) {
            this.pos = pos;
            this.sec = sec;
        }
    }
}

