class Solution {
    public int solution(String arr[]) {
        Calculator c = new Calculator(arr);
        int answer = c.getMaxValue();
        
        return answer;
    }
}

class Calculator{
    boolean[][] isCalcMax;
    boolean[][] isCalcMin;
    int[][] maxDp;
    int[][] minDp;
    int[] nums;
    String[] ops;
    
    public Calculator(String arr[]){
        nums = new int[arr.length/2 +1];
        ops = new String[arr.length/2];
        
        for (int i=0; i<arr.length; i+=2){
            nums[i/2] = Integer.parseInt(arr[i]);
        }
        
        for (int i=1; i<arr.length; i+=2){
            ops[i/2] = arr[i];
        }
    }
    
    public void initDp(){
        int len = nums.length;
        maxDp = new int[len][len];
        minDp = new int[len][len];
        
        isCalcMax = new boolean[len][len];
        isCalcMin = new boolean[len][len];
        
        for (int i=0; i<nums.length; i++){
            maxDp[i][i]=nums[i];
            minDp[i][i]=nums[i];
            isCalcMax[i][i] = true;
            isCalcMin[i][i] = true;
        }
    }
    
    public int getMaxValue(){
        initDp();
        int val = getMaxDp(0,nums.length-1);
        
        return val;
    }
    
    public int getMaxDp(int i, int j){
        if(isCalcMax[i][j]){
            return maxDp[i][j];
        }
        
        int max = -2100000000;
        
        for (int k=i; k<j; k++){
            if("+".equals(ops[k])){
                max = Math.max(max,getMaxDp(i,k)+getMaxDp(k+1,j));
            } else{
                max = Math.max(max,getMaxDp(i,k)-getMinDp(k+1,j));
            }
        }
        
        maxDp[i][j] = max;
        isCalcMax[i][j] = true;
        
        return max;
    }
    
    
    public int getMinDp(int i, int j){
        if(isCalcMin[i][j]){
            return minDp[i][j];
        }
        
        int min = 2100000000;
        
        for (int k=i; k<j; k++){
            if("+".equals(ops[k])){
                min = Math.min(min,getMinDp(i,k)+getMinDp(k+1,j));
            } else{
                min = Math.min(min,getMinDp(i,k)-getMaxDp(k+1,j));
            }
        }
        
        minDp[i][j] = min;
        isCalcMin[i][j] = true;
        
        return min;
    }
    
}