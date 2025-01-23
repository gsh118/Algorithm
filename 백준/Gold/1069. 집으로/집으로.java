import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr=new int[4];
        for (int i=0; i<4; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        br.close();
        System.out.println(getMinComeBackTime(arr[0],arr[1],arr[2],arr[3]));
    }

    public static double getMinComeBackTime(int x, int y, int d, int t){
        double dist = Math.pow(x*x + y*y,0.5);
        return getTimeByDist(dist, d, t);
    }

    private static double getTimeByDist(double dist, int d, int t){
        if(d<t)
            return dist;
        
        if(dist>2*d){
            int q = (int)(dist/d)-1;
            return q*t+getTimeByDist(dist-q*d, d, t);
        }

        return Math.min(dist, Math.min(2*t, t+Math.abs(dist-d)));
    }
}