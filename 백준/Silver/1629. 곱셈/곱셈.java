import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        long[] arr = new long[3];

        for (int i=0; i<3; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long result = exp(arr[0],arr[1],arr[2]);
        System.out.println(result);
    }

    public static long exp(long a, long b, long c){
        if(b==1){
            return a%c;
        }

        if(b%2==1){
            return ((a%c)*exp(a,b-1,c))%c;
        }

        long tmp = exp(a,b/2,c)%c;
        return (tmp*tmp)%c;
    }
}