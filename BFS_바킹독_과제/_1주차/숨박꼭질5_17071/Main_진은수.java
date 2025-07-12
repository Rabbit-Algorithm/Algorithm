package BFS_바킹독_과제._1주차.숨박꼭질5_17071;

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

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0, end));
        boolean[][] visited = new boolean[2][500001];
        visited[0][start] = true;

        int time = -1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            if (visited[now.time % 2][now.end]) {
                time = now.time;
                break;
            }

            int nextTime = now.time + 1;
            int nextEndPoint = now.end + nextTime;
            int nextFlag = (now.time + 1) % 2;

            if (nextEndPoint > 500_000) {
                break;
            }

            if (now.start * 2 <= 500_000 && !visited[nextFlag][now.start * 2]) {
                queue.offer(new Node(now.start * 2, nextTime, nextEndPoint));
                visited[nextFlag][now.start * 2] = true;
            }

            if (now.start - 1 >= 0 && !visited[nextFlag][now.start - 1]) {
                queue.offer(new Node(now.start - 1, nextTime, nextEndPoint));
                visited[nextFlag][now.start - 1] = true;
            }

            if (now.start + 1 <= 500_000 && !visited[nextFlag][now.start + 1]) {
                queue.offer(new Node(now.start + 1, nextTime, nextEndPoint));
                visited[nextFlag][now.start + 1] = true;
            }


        }


        System.out.println(time);
    }

    private static class Node {
        int start;
        int time;
        int end;

        public Node(int start, int time, int end) {
            this.start = start;
            this.time = time;
            this.end = end;
        }
    }


}
