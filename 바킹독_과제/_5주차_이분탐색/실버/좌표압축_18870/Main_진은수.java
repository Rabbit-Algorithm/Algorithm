package 바킹독_과제._5주차_이분탐색.실버.좌표압축_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_진은수 {

    /**
     * 좌표 압축
     * https://www.acmicpc.net/problem/18870
     * 실버2
     */


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[num];

        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sets.add(arr[i]);
        }

        int[] newArr = new int[sets.size()];

        int index = 0;
        for (int i : sets) {
            newArr[index++] = i;
        }

        Arrays.sort(newArr);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(Arrays.binarySearch(newArr, arr[i])).append(" ");
        }

        System.out.println(sb);





    }


}
