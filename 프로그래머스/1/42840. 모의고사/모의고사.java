import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] answers) {
        
        int[][] rule = new int[][] {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] numCnt = new int[3];
        
        for (int i=0; i<3; i++){
            int len = rule[i].length;
            for (int j=0; j<answers.length; j++){
                if(rule[i][j%len] == answers[j]){
                    numCnt[i]++;
                }
            }
        }
        
        int max = Arrays.stream(numCnt)
                        .max().orElse(0);
        
        return IntStream.range(0,3)
                    .filter(i->numCnt[i]==max)
                    .map(i->i+1)
                    .toArray();
    }
}