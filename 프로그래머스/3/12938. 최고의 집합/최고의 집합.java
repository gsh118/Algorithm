class Solution {
    public int[] solution(int n, int s) {   
        if (n>s) {
            return new int[] {-1};
        }
        
        int[] answer = new int [n];
        
        int q=s/n;
        int r=s%n;
        
        for (int i=0; i<n-r; i++){
            answer[i]=q;
        }
        
        for (int i=n-r; i<n; i++){
            answer[i]=q+1;
        }
                    
        return answer;
    }
}