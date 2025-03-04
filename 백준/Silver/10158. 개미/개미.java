import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(br.readLine());

        int nx = getMovedPos(x, w, t);
        int ny = getMovedPos(y, h, t);

        bw.write(nx+" "+ny);

        br.close();
        bw.close();
    }

    public static int getMovedPos(int pos, int len, int time){
        time%=2*len;
        if(pos+time<=len)
            return pos+time;
        if(pos+time<=2*len)
            return 2*len-pos-time;
        return pos+time-2*len;
    }
}