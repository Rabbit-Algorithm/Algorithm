package BFS_바킹독.숨박꼭질3_13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_진은수 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start,0});
        boolean[] visited = new boolean[100001];
        visited[start] = true;

        int time = 0;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == end) {
                time = now[1];
                break;
            }

            if (now[0]*2 <= 100000 && !visited[now[0]*2]) {
                queue.offer(new int[]{now[0]*2, now[1]});
                visited[now[0]*2] = true;
            }

            if (now[0]-1 >= 0 && !visited[now[0]-1]) {
                queue.offer(new int[]{now[0]-1, now[1]+1});
                visited[now[0]-1] = true;
            }

            if (now[0]+1 <= 100000 && !visited[now[0]+1]) {
                queue.offer(new int[]{now[0]+1, now[1]+1});
                visited[now[0]+1] = true;
            }


        }


        System.out.println(time);

    }

}
