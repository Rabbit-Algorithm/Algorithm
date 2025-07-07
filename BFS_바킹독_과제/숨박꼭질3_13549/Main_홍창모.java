package BFS_바킹독.숨박꼭질3_13549;

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

    private static void bfs(int n, int k) {
        Deque<Node> dq = new ArrayDeque<>();

        VISITED[n] = true;
        dq.add(new Node(n, 0));

        while( !dq.isEmpty() ) {
            Node node = dq.poll();

            int position = node.position;
            int time = node.time;

            if( position == k ) {
                ANSWER = time;
                break;
            }

            int[] calPosition = node.calPosition();

            for( int i = 0; i < calPosition.length; i++ ) {
                int nextTime = 0;
                if( i == 0 ) {
                    // 순간이동은 시간이 늘어나지 않으므로, 예외처리
                    nextTime = time;
                } else {
                    nextTime = time+1;
                }

                if( calPosition[i] >= 0 && calPosition[i] <= 100000 && !VISITED[calPosition[i]] ) {
                    VISITED[calPosition[i]] = true;
                    dq.add(new Node(calPosition[i], nextTime));
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
