package 바킹독_과제._5주차_이분탐색.실버.좌표압축_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//X 이 문제를 어떻게 이분탐색으로 적용해야할지 감이 안왔음
public class Main_이승환 {

    static int N; // 좌표의 수
    static long[] coordinates; // 원래 좌표
    static long[] unique; // 정렬 + 중복 제거된 좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        coordinates = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            coordinates[i] = Long.parseLong(st.nextToken());
        }

        //정렬된 복사 배열 만들기
        long[] sorted = coordinates.clone();
        Arrays.sort(sorted);

        //중복 제거한 코드를 unique에 넣어주기
        unique = Arrays.stream(sorted).distinct().toArray();

        StringBuilder sb = new StringBuilder();
        //여기서 각 좌표에 대한 이분 탐색을 진행해서 count를 구해줌
        for(int i=0; i<N; i++){
            int idx = BinarySearch(coordinates[i]);
            sb.append(idx).append(" ");
        }


        System.out.println(sb);

    }

    private static int BinarySearch(long target){
        int left = 0;
        int right = unique.length;

        //어짜피 중복이 없어서 같은 수는 없다
        while (left < right){
            int mid = (left + right) /2;

            if(unique[mid] >= target){
                right = mid; // mid도 후보이기 때문에 right값에 mid를 포함해서 mid-1을 하지 않는 것
            } else {
                left = mid+1;
            }

        }

        return left; // 들어온 값보다 작지 않은 값의 첫 번째 수 = 그 좌표 압축의 값

    }


}
