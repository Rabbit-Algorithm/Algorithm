package 문제풀이.DFS.ABCDE_13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 슈도코드
 *
 * GRAPH<Integer>[] // 친구 정보를 담을 리스트
 *
 * GRAPH = new List[N];
 * for(0부터 N) {
 *     GRAPH[i] = new ArrayList<>;
 * }
 * for(0부터 M) {
 *      // 친구 정보 저장(양방향)
 * }
 *
 * for( 0부터 N ) {
 *      // 방문 초기화
 *     if( dfs(i, depth) ) {
 *         // 1 출력
 *     } else {
 *         // 0 출력
 *     }
 * }
 *
 * boolean dfs(start, depth) {
 *     // Stack에 저장
 *
 *     while() {
 *
 *         Friend curr = stack.pop();
 *         if( curr.depth >= 5 ) {
 *             return true;
 *         }
 *     }
 *
 *     return false;
 * }
 *
 * */
public class Main_홍창모 {

    static int N, M;
    static boolean FOUND = false;
    static List<Integer>[] FRIENDS;
    static boolean[] VISITED;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        FRIENDS = new List[N];
        VISITED = new boolean[N];

        for (int i = 0; i < N; i++) {
            FRIENDS[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            FRIENDS[a].add(b);
            FRIENDS[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if( FOUND ) break;
        }

        System.out.println(FOUND ? 1 : 0);
    }

    private static void dfs(int start, int depth) {

        if (depth == 5) {
            FOUND = true;
            return;
        }

        VISITED[start] = true;

        for( int friend : FRIENDS[start] ) {

            if( !VISITED[friend] ) {
                dfs(friend, depth + 1);
            }
            if(FOUND) return;
        }

        VISITED[start] = false;

    }

    private static class Friend {
        int target;
        int depth;

        Friend(int target, int depth) {
            this.target = target;
            this.depth = depth;
        }
    }
}
