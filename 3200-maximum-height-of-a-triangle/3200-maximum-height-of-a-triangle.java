class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        int firstRed = count(red, blue);
        int firstBlue = count(blue, red);

        int ans = Math.max(firstRed, firstBlue);
        return ans;

    }

    int count(int x, int y){
        int count = 0;

        for(int i = 1;; i++){
            if(i%2 == 1 && i<=x){
                x-=i;
            }else if(i %2 == 0 && i<=y){
                y-=i;
            }else{
                break;
            }
            count++;
        }
        return count;
    }
}