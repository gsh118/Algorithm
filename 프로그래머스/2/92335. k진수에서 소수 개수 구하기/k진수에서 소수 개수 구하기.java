import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        List<Integer> list = makeCharArr(n,k);
        
        
        long cur=0;
        for (int i=0; i<list.size(); i++){
            if(list.get(i)==0){
                if(cur>0&& isPrime(cur)){
                    answer++;
                }
                cur=0;
            } else{
                cur = cur*10+list.get(i);
            }
        }
        
        if(cur>0 && isPrime(cur)){
            answer++;
        }
        
        return answer;
    }
    
    List<Integer> makeCharArr(int n, int k){
        List<Integer> c = new ArrayList<>();
        
        while (n>0){
            c.add(n%k);
            n/=k;
        }
        Collections.reverse(c);
                
        return c;
    }

    
    boolean isPrime(long a){
        if(a==1)
            return false;
        for (long i=2; i*i<=a; i++){
            if(a%i==0)
                return false;
        }
        
        return true;
    }
    
    
}