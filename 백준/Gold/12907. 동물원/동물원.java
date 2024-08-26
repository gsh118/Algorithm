import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n=Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        
        int num_mx=0; // 고양이, 토끼 둘 중 많은 동물의 숫자
        
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i]>num_mx) num_mx=arr[i];
        }
        
        num_mx+=1;

        if (num_mx> n || num_mx<n/2){
            System.out.println(0);
            return;
        }

        int num_mn=n-num_mx;

        int[] cnt = new int[num_mx];
        for (int i=0; i<n; i++) {
            cnt[arr[i]]++;
        }

        boolean isValid=true;

        for (int i=0; i<num_mn; i++){
            if(cnt[i]!=2){
                isValid=false;
                break;
            }
        }

        for (int i=num_mn; i<num_mx; i++){
            if(cnt[i]!=1){
                isValid=false;
                break;
            }
        }

        if(isValid){
            if(num_mn==num_mx){
                System.out.println(1<<(num_mn));
            } else{
                System.out.println(1<<(num_mn+1));
            }
        } else{
            System.out.println(0);
        }
    }
    
    public static void main(String[] args) throws IOException {
        solution();
    }
}