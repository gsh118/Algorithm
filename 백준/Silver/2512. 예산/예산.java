import java.io.*;
import java.util.*;

class Main{
    static int INF = (int) 1e9;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int mx=0;

        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(mx<arr[i]){
                mx=arr[i];
            }
        }

        int m = Integer.parseInt(br.readLine());
        br.close();

        int limit = Math.min(findMinLimit(arr, m), mx);
        System.out.println(limit);
    }

    public static int getRequireBudget(int[] arr, int limit){
        return Arrays.stream(arr)
                .map(n-> Math.min(n, limit))
                .sum();
    }

    public static int findMinLimit(int[] arr, int budget){
        int left = 0;
        int right = INF;

        int validLim = INF+1;
        while(left<=right){
            int mid = left+ (right-left)/2;
            if(getRequireBudget(arr,mid)<=budget){
                validLim = mid;
                left=mid+1;
            } else{
                right=mid-1;
            }
        }

        return validLim;
    }
}