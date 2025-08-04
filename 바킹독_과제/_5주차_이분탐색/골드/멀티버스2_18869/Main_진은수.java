package 바킹독_과제._5주차_이분탐색.골드.멀티버스2_18869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    /**
     * 멀티버스2
     * https://www.acmicpc.net/problem/18869
     * 골드5
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ySize = Integer.parseInt(st.nextToken());
        int xSize = Integer.parseInt(st.nextToken());


        int[][] arr = new int[ySize][xSize];
        int[][] arrSort = new int[ySize][xSize];


        // 원본 배열, 정렬된 배열 2개 만들기
        for (int y = 0; y < ySize; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0 ; x < xSize; x++) {
                arr[y][x] = Integer.parseInt(st.nextToken());
                arrSort[y][x] = arr[y][x];
            }

            Arrays.sort(arrSort[y]);
        }


        // 각 인덱스의 순위를 이분탐색으로 찾기
        for (int y = 0; y < ySize; y++) {
            for (int x = 0 ; x < xSize; x++) {
                arr[y][x] = Arrays.binarySearch(arrSort[y],arr[y][x]);
            }
        }

        // 각 인덱스가 모두 같으면 조건 성립
        int count = 0;
        for (int i = 0 ; i < ySize ; i++) {
            for (int j = i+1 ; j < ySize ; j++) {
                if (Arrays.equals(arr[i], arr[j])) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }

}
