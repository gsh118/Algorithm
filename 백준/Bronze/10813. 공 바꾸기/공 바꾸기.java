import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[] basket = new int[n+1];
        for (int i=1; i<=n; i++){
            basket[i] = i;
        }

        for (int i=0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if (f!=s){
                swapWithoutTempVariable(basket, f, s);
            }
        }

        br.close();

        for (int i=1; i<=n; i++){
            bw.write(basket[i]+" ");
        }
        
        bw.close();
    }

    public static void swapWithoutTempVariable(int[] arr, int i, int j){
        arr[i]+=arr[j];
        arr[j]=arr[i]-arr[j];
        arr[i]=arr[i]-arr[j];
    }
}