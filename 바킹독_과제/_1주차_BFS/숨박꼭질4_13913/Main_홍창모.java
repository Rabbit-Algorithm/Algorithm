
package 바킹독_과제._1주차_BFS.숨박꼭질4_13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {

    static int[] VISITED;
    static int ANSWER;

    static StringBuilder SB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이의 위치
        int N = Integer.parseInt(st.nextToken());
        // 동생의 위치
        int K = Integer.parseInt(st.nextToken());

        VISITED = new int[100001];
        Arrays.fill(VISITED, -1);

        SB = new StringBuilder();
        bfs(N, K);

        System.out.println(ANSWER);
        pathHistory(N, K);
        System.out.println(SB);
    }

    private static void bfs(int n, int k) {
        Deque<Node> dq = new ArrayDeque<>();
        dq.add(new Node(n, 0));

        while (!dq.isEmpty()) {
            Node node = dq.poll();

            int position = node.position;
            int time = node.time;

            if( position == k ) {
                ANSWER = time;
                break;
            }

            int[] calPosition = node.calPosition();
            for( int next : calPosition ) {
                if( next >= 0 && next <= 100000 && VISITED[next] == -1 ) {
                    VISITED[next] = position;
                    dq.add(new Node(next, time +1));
                }
            }
        }
    }

    public static void pathHistory(int n, int k) {
        Stack<Integer> stack = new Stack<>();

        int cur = k;

        stack.push(k);

        while( cur != n ) {
            stack.push(VISITED[cur]);
            cur = VISITED[cur];
        }

        while (!stack.isEmpty()) {
            SB.append(stack.pop()).append(" ");
        }
    }

    static class Node {
        int position;
        int time;

        public Node(int position, int time) {
            this.position = position;
            this.time = time;
        }

        public int[] calPosition() {
            int[] position = new int[3];

            position[0] = this.position * 2;
            position[1] = this.position - 1;
            position[2] = this.position + 1;

            return position;
        }
    }
}
