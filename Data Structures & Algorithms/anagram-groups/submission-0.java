class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

           mp.putIfAbsent(sorted, new ArrayList<>());
           mp.get(sorted).add(str);

        }


        for(Map.Entry<String, List<String>> entry : mp.entrySet()){
            ans.add(entry.getValue());
        }

         return ans;
    }
}
