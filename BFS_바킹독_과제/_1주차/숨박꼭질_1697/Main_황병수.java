package BFS_바킹독_과제._1주차.숨박꼭질_1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main_황병수 {

    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        bfs(N, K);
    }

    private static void bfs(int N, int K) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pos = poll[0];
            int sec = poll[1];

            // 동생을 찾으면 출력 후 종료
            if (pos == K) {
                System.out.println(sec);
                return;
            }

            int[] next = {pos * 2, pos - 1, pos + 1};
            for (int npos : next) {
                if (npos >= 0 && npos <= 100000 && !visited[npos]) {
                    visited[npos] = true;
                    queue.add(new int[]{npos, sec + 1});
                }
            }
        }
    }
}

