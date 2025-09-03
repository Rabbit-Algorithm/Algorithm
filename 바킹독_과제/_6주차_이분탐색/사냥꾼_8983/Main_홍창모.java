package 바킹독_과제._6주차_이분탐색.사냥꾼_8983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_홍창모 {

    static int N, M, L;
    static int[] SHOOTERS;
    static List<Node> ANIMALS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        SHOOTERS = new int[N];

        st = new StringTokenizer(br.readLine());
        for( int i = 0; i < N; i++ ) {
            SHOOTERS[i] = Integer.parseInt(st.nextToken());
        }

        ANIMALS = new ArrayList<>();

        for( int i = 0; i < M; i++ ) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            ANIMALS.add(new Node(x,y));
        }

        Arrays.sort(SHOOTERS);

        System.out.print(binarySearch());
    }

    private static int binarySearch() {
        int count = 0;

        for( Node node : ANIMALS ) {
            int currX = node.x;
            int currY = node.y;

            int left = 0;
            int right = N -1;

            while (left <= right) {
                int mid = left + (right-left) / 2;

                int calc = Math.abs(SHOOTERS[mid] - currX) + currY;

                if( calc <= L ) {
                    count++;
                    break;
                }

                if( currX < SHOOTERS[mid] ) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return count;
    }

    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
