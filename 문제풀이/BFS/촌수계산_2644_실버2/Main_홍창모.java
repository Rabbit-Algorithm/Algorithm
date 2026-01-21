package 문제풀이.BFS.촌수계산_2644_실버2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_홍창모 {

    static int N, A, B;
    static List<Integer>[] GRAPH;
    static int[] CHONSU;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        GRAPH = new ArrayList[N + 1];
        CHONSU = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            GRAPH[i] = new ArrayList<>();
        }

        StringTokenizer st =  new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int iter = Integer.parseInt(br.readLine());

        for (int i = 0; i < iter; i++) {
            st =  new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 부모
            int y = Integer.parseInt(st.nextToken()); // 자식

            GRAPH[x].add(y);
            GRAPH[y].add(x);
        }

        System.out.print(bfs());
    }

    private static int bfs() {

        Deque<Integer> dq = new ArrayDeque<>();

        dq.add(A);
        CHONSU[A] = 0;

        while (!dq.isEmpty()) {
            int curr = dq.poll();

            if( curr == B ) {
                return CHONSU[B];
            }

            for(int next : GRAPH[curr]) {

                if(CHONSU[next] == 0) {
                    CHONSU[next] = CHONSU[curr] + 1;
                    dq.add(next);
                }
            }
        }

        return -1;
    }
}
