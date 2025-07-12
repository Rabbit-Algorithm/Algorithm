/** 참고사항
 * 1. 배열 메모리 할당:
 * VISITED 배열은 크기가 100001인 int 배열입니다.
 * Java에서 int는 4바이트를 차지하므로, 이 배열은 약 100001 * 4 = 400,004 바이트(약 400KB)의 메모리를 사용합니다.
 *
 * 2. 초기화 작업:
 * Arrays.fill(VISITED, -1) 메서드는 배열의 모든 요소를 -1로 설정합니다.
 * 이 작업은 배열의 각 요소에 대해 반복적으로 값을 설정하므로, 초기화 과정에서 CPU 연산이 추가로 발생합니다.
 * 하지만 메모리 사용량 자체는 배열 생성 시 이미 할당되었기 때문에, 초기화로 인해 추가적인 메모리가 사용되지는 않습니다.
 * */
package BFS_바킹독_과제._1주차.숨박꼭질4_13913;

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
