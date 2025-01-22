class Solution {
    public boolean areOccurrencesEqual(String s) {

       int[] arr = new int[26];
       int cnt = 0;
       for(char c: s.toCharArray()){
            arr[c-'a']++;
       } 
       Set<Integer> set = new HashSet<>();
       for(int i:arr){
        set.add(i);
       }
      set.remove(0);
     return (set.size()==1) ? true:false;

    }
}