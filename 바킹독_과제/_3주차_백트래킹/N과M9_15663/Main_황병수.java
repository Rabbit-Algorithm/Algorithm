package 바킹독_과제._3주차_백트래킹.N과M9_15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int N,M;
    static int[] result;
    static HashSet<String> resultSet = new HashSet<>();
    static int[] input;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        input = new int[N];
        result = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input);

        backtracking(0);
        System.out.println(sb);
    }

    private static void backtracking(int depth) {

        if (depth == M) {
            StringBuilder tempSb = new StringBuilder();
            for (int v : result) tempSb.append(v).append(" ");
            String key = tempSb.toString();
            if (!resultSet.contains(key)) {
                resultSet.add(key);
                sb.append(key).append("\n");
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = input[i];
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}
