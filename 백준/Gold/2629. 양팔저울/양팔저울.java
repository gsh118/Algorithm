import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int numWeight = Integer.parseInt(br.readLine());
        int[] weights = new int[numWeight];
        st=new StringTokenizer(br.readLine());

        for (int i=0; i<numWeight; i++){
            weights[i]=Integer.parseInt(st.nextToken());
        }

        int numBead = Integer.parseInt(br.readLine());
        int[] beads = new int[numBead];
        st=new StringTokenizer(br.readLine());

        WeightCheck wc = new WeightCheck(weights);
        for (int i=0; i<numBead; i++){
            beads[i]=Integer.parseInt(st.nextToken());

            String check = wc.canCheck(beads[i])?"Y":"N";
            bw.write(check+" ");
        }

        br.close();
        bw.close();
    }
}


class WeightCheck{
    int[] weights;
    boolean[] checkArr;

    public WeightCheck(int[] weights){
        this.weights = weights;
    }

    public boolean canCheck(int n){
        if(checkArr==null){
            checkArr = new boolean[40001];
            fillCheckArr();
        }

        return checkArr[n];
    }

    private void fillCheckArr(){
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(0);
        checkArr[0]=true;
        for (int w:weights){
            int len = arr.size();
            for (int i=0; i<len; i++){
                int a= arr.get(i);
                if(!checkArr[a+w] && a+w<=40000){
                    arr.add(a+w);
                    checkArr[a+w]=true;
                }

                int diff=Math.abs(a-w);
                if(!checkArr[diff]){
                    arr.add(diff);
                    checkArr[diff]=true;
                }
            }
        }
    }
}