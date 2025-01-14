import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());

        int[] arr=new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(new Main().solveByParametricSearch(arr,s));
    }

    public int solveByParametricSearch(int[] arr, int s){
        long[] accSumArr = makeAccumulateSumArray(arr);
        int minLength = arr.length+1;

        for (int start=0; start<arr.length; start++){
            int curLength = findMinLengthWhenStartFix(start, accSumArr, arr, s);

            if (curLength>0 && curLength<=minLength){
                minLength = curLength;
            }
        }

        return minLength<=arr.length? minLength : 0;
    }

    public long[] makeAccumulateSumArray(int[] arr){
        long[] accSumArr = new long[arr.length];
        if (arr.length>0){
            accSumArr[0]=arr[0];

            for (int i=1; i<arr.length; i++){
                accSumArr[i] = accSumArr[i-1]+arr[i];
            }
        }

        return accSumArr;
    }

    public int findMinLengthWhenStartFix(int start, long[] accSumArr, int[] arr, int s){
        int minLength=accSumArr.length+1;

        int left=start;
        int right=accSumArr.length-1;

        while(left<=right){
            int mid = (right+left)/2;
            long currentAccSum = accSumArr[mid]-accSumArr[start]+arr[start];

            if(currentAccSum>=s) {
                minLength = mid-start+1;
                right = mid-1;
            } else{
                left = mid+1;
            }
        }

        return minLength<=accSumArr.length? minLength : 0;
    }
}