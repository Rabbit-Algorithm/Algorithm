package BFS_바킹독_과제._1주차.숨박꼭질5_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static boolean[][] VISITED;
    static int MAX = 500_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이의 위치
        int N = Integer.parseInt(st.nextToken());
        // 동생의 위치
        int K = Integer.parseInt(st.nextToken());

        VISITED = new boolean[MAX+1][2];

        BFS(N, K);
    }

    static void BFS(int n, int k) {
        Deque<Node> dq = new ArrayDeque<>();

        dq.add(new Node(n, 0, k));
        VISITED[n][0] = true;

        while (!dq.isEmpty()) {
            Node curr = dq.poll();
            int currSubin = curr.subin;
            int nextSister = curr.sister + curr.time;


            if( MAX < nextSister ) {
                System.out.println(-1);
                break;
            }

            if( VISITED[nextSister][curr.time % 2] ) {
                System.out.println(curr.time);
                break;
            }

            // 수빈이가 다음 이동할 위치 배열
            int[] nextSubin = curr.calPosition(currSubin);
            int nextTime = curr.time + 1;

            for( int next : nextSubin ) {
                if( next >= 0 && next <= 500_000 && !VISITED[next][nextTime % 2] ) {
                    dq.add(new Node(next, nextTime, nextSister));
                    VISITED[next][nextTime % 2] = true;
                }
            }
        }
    }

    static class Node {
        // 수빈이의 위치
        int subin;
        // 경과 시간
        int time;
        // 동생의 위치
        int sister;

        public Node(int subin, int time, int sister) {
            this.subin = subin;
            this.time = time;
            this.sister = sister;
        }

        public int[] calPosition(int pos) {
            int[] position = new int[3];

            position[0] = pos * 2;
            position[1] = pos - 1;
            position[2] = pos + 1;

            return position;
        }

    }
}
