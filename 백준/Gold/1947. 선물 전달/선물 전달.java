import java.util.*;
import java.io.*;

class Main{
    static long mod=1000000000;
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        
        System.out.println(calcCompletePermutation(n));
    }
    
    public static long calcCompletePermutation(int n){
        if(n==1){
            return 0;
        }
        
        long[] permArr = new long[n+1];
        permArr[1]=0;
        permArr[2]=1;
        
        for (int i=3; i<=n; i++){
            permArr[i]=(i-1)*(permArr[i-1]+permArr[i-2]);
            permArr[i]%=mod;
        }
        
        return permArr[n];
    }
}