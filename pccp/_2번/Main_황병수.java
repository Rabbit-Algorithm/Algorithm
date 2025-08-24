package pccp._2번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int M;
    static int N;
    static int[][] map;
    static List<Integer>[] list;
    static List<Integer> result = new ArrayList<>();
    static boolean[] visited;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        map = new int[M][2];
        visited =  new boolean[M+1];

        list = new List[M+1];
        for(int i = 0; i <= M; i++) list[i] = new ArrayList<>();


        for (int i = 0; i < 8; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 8; i++) {
            list[map[i][1]].add(map[i][0]);
            list[map[i][0]].add(map[i][1]);
        }

        while (true) {

            boolean[] tempVisited = new boolean[M + 1];
            // visited 모두 true 일 떄 종료
            if (findPosition() == 0) {
                break;
            }

            // visited가 미방문인 경우, 가장 낮은 정점으로 시작
            int position = findPosition();
            dfs(position, N, tempVisited);
            result.add(position);
            sb.append(result.toString()).append("\n");
            result.clear();

        }


        System.out.println(sb.toString());
    }

    static void dfs(int nowP, int distance, boolean[] tempVisited) {
        tempVisited[nowP] = true;
        visited[nowP] = true;

        if (distance == 0) {
            return;
        }

        for (int child : list[nowP]) {
            if (!tempVisited[child]) {
                if (visited[child]) {
                    dfs(child, distance - 1, tempVisited);

                } else {
                    visited[child] = true;
                    result.add(child);
                    dfs(child, distance - 1, tempVisited);
                }
            }
        }
    }




    static int findPosition() {
        for (int i = 1; i <= M; i++) {
            if (!visited[i]) {
                return i;
            }
        }

        return 0;
    }
}
