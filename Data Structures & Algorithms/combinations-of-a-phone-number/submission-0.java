class Solution {
    public void helper(String digits,Map<Character, String>  mp ,int ind,StringBuilder ds, List<String> ans){

        if(ind==digits.length()){
            ans.add(ds.toString());
            return;
        }
       
        String str = mp.get(digits.charAt(ind));

        for(int i=0;i<str.length();++i){
          ds.append(str.charAt(i));
           helper(digits, mp , ind+1, ds, ans);
          ds.deleteCharAt(ds.length()-1);
        }



    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> mp = new HashMap<>();
        List<String> ans = new ArrayList<>();
        StringBuilder ds = new StringBuilder();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");

        if(digits.length()==0){
            return ans;
        }


        helper(digits, mp , 0, ds, ans);

        return ans;
        

    }
}
