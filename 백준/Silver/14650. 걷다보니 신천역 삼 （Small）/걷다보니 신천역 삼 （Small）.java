import java.util.*;

public class Main {
    public static int cnt;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n==1){
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];
        arr[0] = 1;
        countMultiPly(arr, 1, n);
        arr[0] = 2;
        countMultiPly(arr, 1, n);

        System.out.println(cnt);
    }

    public static void countMultiPly(int[] arr, int idx, int n){
        if(idx==n){
            int sum=0;
            for (int i=0; i<n; i++){
                sum+=arr[i];
            }

            if(sum%3==0){
                cnt++;
            }
            return;
        }

        for (int i=0; i<3; i++){
            arr[idx]=i;
            countMultiPly(arr, idx+1, n);
        }
    }
}