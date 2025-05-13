import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            char[] arr = st.nextToken().toCharArray();

            StringBuilder sb = new StringBuilder();
            for (char c:arr){
                sb.append((c+"").repeat(r));
            }
            sb.append("\n");

            bw.write(sb.toString());
        }

        br.close();
        bw.close();
    }
}