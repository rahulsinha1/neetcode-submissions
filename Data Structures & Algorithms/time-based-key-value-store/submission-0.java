class TimeMap {
    Map<String, List<Data>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Data data = new Data(value, timestamp);
        if(!map.containsKey(key)){
            List<Data> dataList = new ArrayList<>();
            map.put(key,dataList);
        }
        map.get(key).add(data);
    }
    
    public String get(String key, int timestamp) {
        List<Data> list = map.get(key);
        if (list == null) return "";    
        String result = "";   
        int low =0;
        int high = list.size()-1;

        while (low<=high){
            int mid = low+(high-low)/2;

            if (list.get(mid).getTimestamp()<=timestamp ){
                result = list.get(mid).getValue();
                low = mid+1;
            }
            else if (list.get(mid).getTimestamp()>timestamp){
                high = mid-1;
            }
        }
        return result;
    }
}

class Data{
    int timestamp;
    String value;

    public Data(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue(){
        return value;
    }

    public int getTimestamp(){
        return timestamp;
    }
}
