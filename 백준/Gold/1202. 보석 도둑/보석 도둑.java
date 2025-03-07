import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[n];
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m,v);
        }

        int[] bags = new int[k];
        for (int i=0; i<k; i++){
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }

        long result = getMaximumSum(jewels, bags);
        System.out.println(result);
    }

    static long getMaximumSum(Jewel[] jewels, int[] bags) {
        Arrays.sort(bags);
        Arrays.sort(jewels, Comparator.comparing(Jewel::getWeight));

        long sum = 0;
        int jewelIdx = 0;
        PriorityQueue<Jewel> pq = new PriorityQueue<>(
                Comparator.comparing(Jewel::getValue).reversed()
                        .thenComparing(Jewel::getWeight)
        );
        
        for (int capacity : bags) {
            while (jewelIdx < jewels.length && jewels[jewelIdx].weight <= capacity) {
                pq.add(jewels[jewelIdx]);
                jewelIdx++;
            }

            if (!pq.isEmpty()) {
                sum += pq.remove().value;
            }
        }

        return sum;
    }
}

class Jewel{
    int weight;
    int value;

    public Jewel(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}