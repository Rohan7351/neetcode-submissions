class TimeMap {

    class Pair{
        String value;
        int timestamp;

        Pair(String value, int timestamp){
           this.value = value;
           this.timestamp = timestamp;
        }
    }

    Map<String, List<Pair>> ds;

    public TimeMap() {
        ds = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(ds.containsKey(key)){
          ds.get(key).add(new Pair(value,timestamp));
        }else{
          List<Pair> ls = new ArrayList<>();
          ls.add(new Pair(value,timestamp));
          ds.put(key, ls);
        }
        
    }
    
    public String get(String key, int timestamp) {
        if(!ds.containsKey(key)){
           return "";
        }

        List<Pair> ls = ds.get(key);

        int l = 0;
        int r = ls.size()-1;
        String ans = "";

        while(l<=r){
            int mid = l+(r-l)/2;
            Pair p = ls.get(mid);

            if(p.timestamp==timestamp){
                return p.value;
            }

            if(p.timestamp<timestamp){  // can be my ans 
              ans = p.value;
              l = mid + 1;
            }else{
              r = mid - 1;
            }
        }

        return ans;
        
    }
}
