class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        //가로, 세로의 합과 곱
        int sum = brown/2+2;
        int mul = yellow+brown;
        
        for (int a=1; a*a<=mul; a++){
            if(mul%a==0){
                int b = mul/a;
                if (a+b==sum){
                    answer = new int[]{b,a};
                    break;
                }
            }
        }
        return answer;
    }
}