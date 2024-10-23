class Solution {
    public char findTheDifference(String s, String t) {

        // 1 -> usig in Build HashMap (Brute force)
        // return usingHashMap(s, t);

        // 2 -> using custom hashing (Optimal)
        return customHashing(s, t);
    }

    public char usingHashMap(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (char ch : t.toCharArray()) {
            if (map.containsKey(ch) && map.get(ch) > 0) {
                map.put(ch, map.get(ch) - 1);
            } else {
                return ch;
            }
        }
        return ' ';
    }

    public char customHashing(String s, String t) {

        int hash[] = new int[26];

        for (char ch : s.toCharArray()) {
            hash[ch - 'a'] = hash[ch - 'a'] + 1;
        }

        for (char ch : t.toCharArray()) {
            if (hash[ch - 'a'] > 0) {
                hash[ch - 'a'] = hash[ch - 'a'] - 1;
            } else {
                return ch;
            }
        }
        return ' ';
    }
}