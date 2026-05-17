class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String str : strs){
            int[] freq = new int[26];
            for(char ch : str.toCharArray()){
                freq[ch-'a']++;
            }
           StringBuilder key = new StringBuilder();
            for(int count : freq){
                key.append(count).append('#');
            }
  
           String keyStr = key.toString();
            if(!mp.containsKey(keyStr)){
                mp.put(keyStr, new ArrayList<>());
            }
             mp.get(keyStr).add(str);

        }


        for(Map.Entry<String, List<String>> entry : mp.entrySet()){
            ans.add(entry.getValue());
        }

         return ans;
    }
}
