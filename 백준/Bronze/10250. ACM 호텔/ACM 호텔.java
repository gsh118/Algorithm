import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while ((t--)>0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            bw.write(getRoomNumber(h,w,n)+"\n");
        }

        br.close();
        bw.close();
    }

    static String getRoomNumber(int h, int w, int n){
        int roomWidth = (n-1)/h+1;
        int roomHeight = (n-1)%h+1;

        if(roomWidth<10){
            return roomHeight+"0"+roomWidth;
        }
        return roomHeight+""+roomWidth;
    }
}