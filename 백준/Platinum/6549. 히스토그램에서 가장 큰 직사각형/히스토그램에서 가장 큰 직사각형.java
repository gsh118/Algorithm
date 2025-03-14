import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            if(n==0){
                break;
            }

            int[] arr = new int[n];
            for (int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] nge = makeNearestGreatOrEnd(arr);
            
            int[] revArr = getRevArr(arr);
            int[] nle = getRevArr(makeNearestGreatOrEnd(revArr));
            for (int i=0; i<n; i++){
                nle[i] = n-1-nle[i];
            }

            long maxArea = getMaxDistArea(arr, nge, nle);
            bw.write(maxArea+"\n");
        }
        br.close();
        bw.close();
    }

    public static int[] getRevArr(int[] arr){
        int n = arr.length;
        int[] revArr = new int[n];

        int j=0;
        for (int i=n-1; i>=0; i--){
            revArr[j] = arr[i];
            j++;
        }
        return revArr;
    }

    public static int[] makeNearestGreatOrEnd(int[] arr){
        Deque<int[]> dq = new LinkedList<>();
        int[] nge = new int[arr.length];
        Arrays.fill(nge, arr.length);

        for (int i=0; i<arr.length; i++){
            while(!dq.isEmpty()){
                //idx, val
                int[] cur = dq.peekLast();
                if(cur[1]>arr[i]){
                    nge[cur[0]] = i;
                    dq.removeLast();
                } else{
                    break;
                }
            }
            int[] tmp = {i, arr[i]};
            dq.addLast(tmp);
        }

        return nge;
    }
    public static long getMaxDistArea(int[] arr, int[] nge, int[] nle){
        long maxArea=0;
        int n = arr.length;
        for (int i=0; i<n; i++){
            long curArea = (long)(nge[i]-i)*arr[i]+ (long)(i-nle[i])*arr[i]-arr[i];
            maxArea = Math.max(curArea, maxArea);
        }

        return maxArea;
    }
}