package BFS_바킹독_과제._1주차.숨박꼭질5_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_황병수 {

    static final int MAX = 500_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[MAX + 1][2];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);
        visited[N][0] = true;

        int time = 0;
        while (true) {
            int sister = K + time * (time + 1) / 2;
            if (sister > MAX) {
                System.out.println(-1);
                return;
            }
            if (visited[sister][time % 2]) {
                System.out.println(time);
                return;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                int nextTime = (time + 1) % 2;
                int[] nextArr = {cur - 1, cur + 1, cur * 2};
                for (int next : nextArr) {
                    if (next < 0 || next > MAX || visited[next][nextTime]) continue;
                    visited[next][nextTime] = true;
                    queue.add(next);
                }
            }
            time++;
        }
    }
}
