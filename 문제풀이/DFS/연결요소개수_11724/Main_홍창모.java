package 문제풀이.DFS.연결요소개수_11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M;
    static List<Integer>[] GRAPH;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        GRAPH = new ArrayList[N+1];
        VISITED = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            GRAPH[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            GRAPH[u].add(v);
            GRAPH[v].add(u);
        }

        int count = 0;

        for (int i = 1; i <= N; i++) {
            if( !VISITED[i] ) {
                dfs(i);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int start) {
        Stack<Integer> stack = new Stack<>();
        VISITED[start] = true;

        stack.push(start);

        while (!stack.isEmpty()) {
            int curr = stack.pop();

            for( int x : GRAPH[curr] ) {
                if( !VISITED[x] ) {
                    stack.push(x);
                    VISITED[x] = true;
                }
            }
        }
    }
}
