import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static int solution(long minVal, long maxVal){
        boolean[] nsq = new boolean[1000002];
        int cnt=0;

        for (long i=2; i*i<=maxVal; i++) {
            for (long j=minVal/(i*i); i*i*j<=maxVal; j++) {
                if(j<1) continue;
                if (i*i*j>=minVal) nsq[(int) (i*i*j-minVal)]=true;
            }
        }

        for (int i=0; i<=(int)(maxVal-minVal); i++){
            if(!nsq[i]) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
        long minVal = Long.parseLong(st.nextToken());
        long maxVal = Long.parseLong(st.nextToken());

        System.out.println(solution(minVal, maxVal));
    }
}