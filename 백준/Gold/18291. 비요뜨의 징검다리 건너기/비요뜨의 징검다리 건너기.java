import java.io.*;

public class Main{
    static long mod = 1_000_000_007;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(exp(n-2)+"\n");
        }
        br.close();
        bw.close();
    }

    static long exp(int pow){
        if (pow<=0){
            return 1;
        }

        if (pow%2==1){
            return exp(pow-1)*2%mod;
        }

        long tmp = exp(pow/2);
        return tmp*tmp%mod;
    }
}