import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=  new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        boolean[] cards = new boolean[27];
        cards[0] = true;


        for (int i=0; i<n; i++){
            List<Integer> arr = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                arr.add(Integer.parseInt(st.nextToken()));
            }
            shuffle(cards, arr);
        }

        for (int i=0; i<cards.length; i++){
            if(cards[i]){
                System.out.println(i+1);
                break;
            }
        }
    }

    public static void shuffle(boolean[] cards, List<Integer> arr){
        boolean[] left = new boolean[13];
        boolean[] right = new boolean[14];

        for (int i=0; i<13; i++){
            left[i] = cards[i];
        }

        for (int i=13; i<27; i++){
            right[i-13] = cards[i];
        }

        boolean isRightTurn = true;

        int rightIdx=0;
        int leftIdx=0;

        int newCardIdx=0;
        for(int n:arr){
            for (int i=0; i<n; i++){
                if(isRightTurn){
                    cards[newCardIdx++] = right[rightIdx++];
                } else{
                    cards[newCardIdx++] = left[leftIdx++];
                }
            }
            isRightTurn=!isRightTurn;
        }
    }
}