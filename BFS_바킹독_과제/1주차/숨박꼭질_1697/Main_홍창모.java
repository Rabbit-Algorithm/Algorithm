package BFS_바킹독_과제._1주차.숨박꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int ANSWER = 0;
    static boolean[] VISITED;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이의 위치
        int N = Integer.parseInt(st.nextToken());
        // 동생의 위치
        int K = Integer.parseInt(st.nextToken());

        VISITED = new boolean[100001];

        bfs(N, K);

        System.out.println(ANSWER);
    }

    public static void bfs(int n, int k) {
        Deque<Node> dq = new ArrayDeque<>();

        dq.add(new Node(n,0));
        VISITED[n] = true;

        while (!dq.isEmpty()) {
            Node node = dq.poll();

            int position = node.position;
            int time = node.time;

            // 현재 위치가 동생의 위치와 같은 경우 ANSWER에 시간을 저장하고 종료
            if( position == k ) {
                ANSWER = time;
                break;
            }

            int[] calPosition = node.calPosition();

            for( int next : calPosition ) {
                if( next >= 0 && next <= 100000 && !VISITED[next] ) {
                    VISITED[next] = true;
                    dq.add(new Node(next, time+1));
                }
            }
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
