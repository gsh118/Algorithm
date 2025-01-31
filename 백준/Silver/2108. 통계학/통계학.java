import java.io.*;
import java.util.*;

class Main{
    static int TRANS_VALUE =-4000;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());
        int[] countingArr = new int[8001];

        for (int i=0; i<n; i++){
            int cur= Integer.parseInt(br.readLine());
            countingArr[cur- TRANS_VALUE]++;
        }
        br.close();

        Main m = new Main();
        bw.write(m.calcAvg(n,countingArr)+"\n"+m.calcMedian(n,countingArr)+"\n"
                +m.calcSecondMode(countingArr)+"\n"+m.calcRange(countingArr));

        bw.close();
    }

    int calcAvg(int n, int[] arr){
        float s=0;
        for (int i=0; i<arr.length; i++){
            s+= (i+ TRANS_VALUE)*arr[i];
        }

        return Math.round(s/n);
    }

    int calcMedian(int n, int[]arr){
        int cnt=0;
        for (int i=0; i<arr.length; i++){
            cnt+=arr[i];
            if(cnt>=n/2+1){
                return i+ TRANS_VALUE;
            }
        }

        return -5000;
    }

    int calcSecondMode(int[] arr){
        ArrayList<Integer> modeArr = new ArrayList<>();
        int mx=-5000;
        for (int i:arr){
            if(i>mx){
                mx=i;
            }
        }

        for (int i=0; i<arr.length; i++){
            if(arr[i]==mx){
                modeArr.add(i+ TRANS_VALUE);
            }
        }

        if(modeArr.size()>=2){
            return modeArr.get(1);
        } else if(modeArr.size()==1){
            return modeArr.get(0);
        }

        return -5000;
    }

    int calcRange(int[] arr){
        int minIdx=0;
        for (int i=0; i<arr.length; i++){
            if(arr[i]>0){
                minIdx=i;
                break;
            }
        }
        int maxIdx=0;

        for (int j=arr.length-1; j>=0; j--){
            if(arr[j]>0){
                maxIdx=j;
                break;
            }
        }

        return maxIdx-minIdx;
    }
}