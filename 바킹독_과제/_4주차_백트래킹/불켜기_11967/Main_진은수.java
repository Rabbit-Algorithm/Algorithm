package 바킹독_과제._4주차_백트래킹.불켜기_11967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    /**
     * 불켜기
     * https://www.acmicpc.net/problem/11967
     * 골드2
     */

    private static int num;
    private static int count = 0;
    private static int size;

    private static boolean[][] visited;
    private static boolean[][] switchUsable;
    private static int[][] map;
    private static List<Point>[][] switchList;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        num = Integer.parseInt(st.nextToken());


        map = new int[size][size];
        visited = new boolean[size][size];
        switchUsable = new boolean[size][size];
        switchList = new List[size][size];
        map[0][0] = 1;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                switchList[y][x] = new ArrayList<>();
            }
        }

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int sx = Integer.parseInt(st.nextToken())-1;
            int sy = Integer.parseInt(st.nextToken())-1;


            switchList[y][x].add(new Point(sx, sy));
            switchUsable[y][x] = true;

        }


        search();

        System.out.println(count);


    }

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static Queue<Point> queue;
    private static void search() {

        queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;
        count++;

        while (!queue.isEmpty()) {

            Point now = queue.poll();

            switchCheck(now.x, now.y);

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];


                if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
                    continue;
                }

                if (!visited[ny][nx] && map[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }


    private static void switchCheck(int x, int y) {

        // 스위치 있는 경우
        if (switchUsable[y][x]) {

            for (Point s : switchList[y][x]) {

                // 스위치가 여러번 방문 할 수 있기 때문에 한번만 카운팅
                if (map[s.y][s.x] == 0) {
                    map[s.y][s.x] = 1;
                    count++;
                }

                // 방문한 곳이면 방문 처리
                if (visited[s.y][s.x]) {
                    queue.add(new Point(s.x, s.y));
                } else { // 방문하지 않은 곳이면 근처에 길이 있는지 확인 = 멀리 순간이동 하는 경우 배제
                    for (int j = 0; j < 4; j++) {
                        int nx = s.x + dx[j];
                        int ny = s.y + dy[j];

                        if (nx < 0 || ny < 0 || nx >= size || ny >= size) {
                            continue;
                        }

                        if (visited[ny][nx] && map[ny][nx] == 1) {
                            visited[s.y][s.x] = true;
                            queue.add(new Point(s.x, s.y));
                            break;
                        }
                    }
                }
            }

            // 사용한 스위치 제거
            switchList[y][x].clear();
        }
    }


    private static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}
