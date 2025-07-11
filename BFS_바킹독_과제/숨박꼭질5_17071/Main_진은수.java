package BFS_바킹독_과제.숨박꼭질5_17071;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_진은수 {


    /**
     * 틀린 코드 입니다.
     * Q. 종료 조건 코드 이유
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0, end});
        boolean[][] visited = new boolean[2][500001];
        visited[0][start] = true;

        int time = -1;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (visited[now[1] % 2][now[2]]) {
                time = now[1];
                break;
            }

            if (now[2] + now[1] + 1 > 50000) {
                break;
            }

            if (now[0] * 2 <= 500000 && !visited[now[1] % 2][now[0] * 2]) {
                queue.offer(new int[]{now[0] * 2, now[1] + 1, now[2] + now[1] + 1});
                visited[now[1] % 2][now[0] * 2] = true;
            }

            if (now[0] - 1 >= 0 && !visited[now[1] % 2][now[0] - 1]) {
                queue.offer(new int[]{now[0] - 1, now[1] + 1, now[2] + now[1] + 1});
                visited[now[1] % 2][now[0] - 1] = true;
            }

            if (now[0] + 1 <= 500000 && !visited[now[1] % 2][now[0] + 1]) {
                queue.offer(new int[]{now[0] + 1, now[1] + 1, now[2] + now[1] + 1});
                visited[now[1] % 2][now[0] + 1] = true;
            }


        }


        System.out.println(time);
    }



}
