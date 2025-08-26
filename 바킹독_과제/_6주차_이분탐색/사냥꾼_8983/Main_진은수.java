package 바킹독_과제._6주차_이분탐색.사냥꾼_8983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_진은수 {

    /**
     * 사냥꾼
     * 골드4
     * 이분탐색
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int hunter = Integer.parseInt(st.nextToken());
        int feed = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());

        int[] arr = new int[hunter];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < hunter; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < feed; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point(x, y));
        }

        int count = 0;
        for (int i = 0; i < points.size(); i++) {

            Point now = points.get(i);

            int low = 0;
            int high = hunter - 1;

            while (low <= high) {

                int mid = (low + high) / 2;
                int huntX = arr[mid];
                int dist = now.y + Math.abs(now.x - huntX);

                if (dist <= distance) {
                    count++;
                    break;
                }

                if (now.x < huntX) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }

            }



        }

        System.out.println(count);



    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}