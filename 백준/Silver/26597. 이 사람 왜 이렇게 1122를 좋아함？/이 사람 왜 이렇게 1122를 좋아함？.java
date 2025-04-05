import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long max = (long) Math.pow(10,18);
        long min = -max;
        int q = Integer.parseInt(br.readLine());

        String resultMsg = "Hmm...";
        int cnt=0;

        for (int i=1; i<=q; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long tmp = Long.parseLong(st.nextToken());
            String s = st.nextToken();
            if ("^".equals(s)){
                min = Math.max(min,tmp+1);
            } else{
                max = Math.min(max, tmp-1);
            }

            if(min>max || min>(long)Math.pow(10,18) || max<-(long)Math.pow(10,18)){
                cnt = i;
                resultMsg = "Paradox!";
                break;
            } else if(min==max && cnt==0){
                cnt = i;
                resultMsg = "I got it!";
            }
        }
        br.close();

        System.out.println(resultMsg);
        if(cnt>0){
            System.out.println(cnt);
        }
    }
}