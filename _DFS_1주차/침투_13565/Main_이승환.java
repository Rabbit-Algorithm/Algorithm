package 침투_13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Main_이승환 {

    void DFS(int n){

    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");
        int h = Integer.parseInt(nums[0]);
        int w = Integer.parseInt(nums[1]);
        int[][] arr = new int[h][w];

        for(int i=0; i<h; i++){
            String rowString = br.readLine();
            for(int j=0; j<w; j++){
                arr[i][j] = rowString .charAt(j)- '0';
            }
        }





    }
}
