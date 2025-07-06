package 숨박꼭질3_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_황병수 {

    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }

    private static void bfs(int N, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{N, 0});
        
        dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int pos = poll[0];
            int sec = poll[1];

            // 동생을 찾으면 출력 후 종료
            if (pos == K) {
                System.out.println(sec);
                return;
            }

            // 순간이동(0초)
            if (pos * 2 <= 100000 && dist[pos * 2] > sec) {
                dist[pos * 2] = sec;
                queue.add(new int[]{pos * 2, sec});
            }
            // 걷기(1초)
            if (pos - 1 >= 0 && dist[pos - 1] > sec + 1) {
                dist[pos - 1] = sec + 1;
                queue.add(new int[]{pos - 1, sec + 1});
            }
            if (pos + 1 <= 100000 && dist[pos + 1] > sec + 1) {
                dist[pos + 1] = sec + 1;
                queue.add(new int[]{pos + 1, sec + 1});
            }
        }
    }
}
