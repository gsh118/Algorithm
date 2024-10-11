import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.Math.max;

public class Main {

    public static long solution(int n, int[] arr){

        int[] farArr = new int[n];

        farArr[n-1]=n-1;
        Stack<Integer> stack = new Stack<>();

        stack.push(n-1);
        for (int i=n-2; i>=0; i--){
            int nxt=i;
            while(!stack.empty()){
                if(arr[i]>arr[stack.peek()]){
                    nxt=stack.pop();
                } else{
                    nxt=max(nxt,stack.peek()-1);
                    break;
                }
            }
            
            if (stack.empty()){
                nxt=n-1;
            }

            farArr[i]=nxt;
            stack.push(i);
        }

        long rst = 0;

        for (int i=0; i<n; i++){
            rst+= farArr[i]-i;
        }
        
        return rst;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(n, arr));
    }
}