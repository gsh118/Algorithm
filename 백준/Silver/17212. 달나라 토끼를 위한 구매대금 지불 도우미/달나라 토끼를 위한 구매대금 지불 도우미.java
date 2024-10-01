import java.util.Scanner;

import static java.lang.Math.min;

public class Main {

    public static int solution(int n){
        int[] arr;
        if (n<=7){
            arr = new int[8];
        } else{
            arr = new int[n+1];
        }
        arr[1]=1; arr[2]=1; arr[3]=2; arr[4]=2; arr[5]=1; arr[6]=2; arr[7]=1;

        for (int i=8; i<=n; i++){
            arr[i]=min(min(arr[i-1],arr[i-2]),min(arr[i-5],arr[i-7]))+1;
        }

        return arr[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}