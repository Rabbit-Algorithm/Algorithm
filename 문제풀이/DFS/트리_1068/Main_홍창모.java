package 문제풀이.DFS.트리_1068;

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
    static List<Integer> ROOT_LIST;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // 노드의 개수
        N = Integer.parseInt(br.readLine());

        GRAPH = new ArrayList[N];
        ROOT_LIST = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            GRAPH[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());

            if( input == -1 ) {
                // root 노드
                ROOT_LIST.add(i);
            } else {
                GRAPH[input].add(i);
            }
        }

        // 지울 노드
        M = Integer.parseInt(br.readLine());

        int result = 0;
        for( int root : ROOT_LIST ) {
            result += dfs(root);
        }

        System.out.println(result);
    }

    private static int dfs(int startIdx) {
        Stack<Integer> stack = new Stack<>();

        if( startIdx == M ) {
            return 0;
        }

        stack.push(startIdx);

        int count = 0;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            int childCnt = 0;

            for( int next : GRAPH[curr] ) {
                if( next == M ) continue;

                childCnt++;
                stack.push(next);
            }

            if( childCnt == 0 ) {
                count++;
            }
        }

        return count;
    }
}
