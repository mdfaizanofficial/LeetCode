class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int[] i : edges){
            for(int j = 0; j < i.length; j++){
                if(map.containsKey(i[j])){
                    map.put(i[j], map.get(i[j])+1);
                }else{
                    map.put(i[j],1);
                }
            }
        }
        int ans = 0;
        for(int i : map.keySet()){
            if(map.get(i)>1){
                ans = i;
            }
        }
        return ans;
    }
}