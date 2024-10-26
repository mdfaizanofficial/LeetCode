class Solution {
    public boolean isAnagram(String s, String t) {
        // using list
        // return approach1(s, t);
        
        
        // using HashMap
        // return approach2(s, t);

        // using custom hashing
        return approach3(s, t);
    }
    boolean approach1(String s, String t){

        List<Character> list = new ArrayList<>();
        for(char ch : t.toCharArray()){
            list.add(ch);
        }
        
        for(int i = 0; i < s.length(); i++){
            if(!list.contains(s.charAt(i))){
                return false;
            }else{
                list.remove(Character.valueOf(s.charAt(i)));
            }
        }
        if(!list.isEmpty()){
            return false;
        }
        return true;
    }
    boolean approach2(String s, String t){
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }

        for(char ch : s.toCharArray()){
            if(map.containsKey(ch) && map.get(ch) > 0){
                map.put(ch, map.get(ch)-1);
            }else{
                return false;
            }
        }
        for(char ch : map.keySet()){
            if(map.get(ch) > 0){
                return false;
            }
        }
        return true;
    }
    boolean approach3(String s, String t){
        int[] hash = new int[26];

        for(char ch : t.toCharArray()){
            hash[ch-'a'] = hash[ch-'a']+1;
        }

        for(char ch : s.toCharArray()){
            if(hash[ch-'a'] <= 0){
                return false;
            }else{
                hash[ch-'a'] = hash[ch-'a']-1;
            }
        }

        for(char ch : t.toCharArray()){
            if(hash[ch-'a'] > 0){
                return false;
            }
        }
        return true;
    }
}