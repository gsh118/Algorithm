import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[k][2];
        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<2; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        long left=1;

        long right=Integer.MAX_VALUE;
        long result=-1;

        while(left<=right){
            long mid = left+(right-left)/2;
            long curLike = getLikeByLevel(arr, n, mid);

            if(curLike<m){
                left=mid+1;
            } else{
                result = mid;
                right = mid-1;
            }
        }

        System.out.println(result);
    }

    public static long getLikeByLevel(int[][] arr, int n, long level){
        int[][] resultArr = Arrays.stream(arr)
                .filter(e->e[1]<=level)
                .toArray(int[][]::new);

        if (resultArr.length<n){
            return -1;
        }

        return Arrays.stream(resultArr)
                .sorted(Comparator.<int[]>comparingInt(a->a[0]).reversed())
                .mapToLong(e->e[0])
                .limit(n)
                .sum();
    }
}