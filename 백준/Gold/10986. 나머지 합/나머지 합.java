import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long[] arr = new long[n+1];
        st = new StringTokenizer(br.readLine());

        for (int i=1; i<=n; i++){
            arr[i] = arr[i-1] + Long.parseLong(st.nextToken());
        }

        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i=0; i<=n; i++){
            int mod = (int) (arr[i]%m);
            int cur = cnt.getOrDefault(mod,0);
            cnt.put(mod, cur+1);
        }

        long result = cnt.values().stream()
                .mapToLong(i-> (long) i*(i-1)/2)
                .sum();

        System.out.println(result);
    }
}