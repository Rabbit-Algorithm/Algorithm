package 바킹독_과제._6주차_이분탐색.세부_13905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N,M;
    static int S,H;
    static List<int[]>[] homes;
    static boolean[] visited;
    static int MAX_GOLD = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        visited= new boolean[N + 1];
        homes = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            homes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int home1 = Integer.parseInt(st.nextToken());
            int home2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            homes[home1].add(new int[]{home2, weight});
            homes[home2].add(new int[]{home1, weight});
        }

        backtracking(S, Integer.MAX_VALUE);

        System.out.println(MAX_GOLD);
    }

    private static void backtracking(int nextHome, int weight) {

        // 도달했을 때
        if (nextHome == H) {
            MAX_GOLD = Math.max(MAX_GOLD, weight);
            return;
        }

        if (weight < MAX_GOLD) {
            return;
        }

        for (int[] next : homes[nextHome]) {
            int nHome = next[0];
            int nWeight = next[1];

            if (!visited[nHome] ) {
                visited[nHome] = true;
                backtracking(nHome, Math.min(nWeight, weight));
                visited[nHome] = false;
            }
        }
    }
}
