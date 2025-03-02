import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int result = pow(a,b);
            result = result%10>0?result:10;
            bw.write(result+"\n");
        }

        br.close();
        bw.close();
    }

    public static int pow(int a, int b){
        if(a==1||b==1){
            return a%10;
        }

        int tmp = pow(a,b/2)%10;

        if(b%2==0){
            return (tmp*tmp)%10;
        } else{
            return a*tmp*tmp%10;
        }
    }
}