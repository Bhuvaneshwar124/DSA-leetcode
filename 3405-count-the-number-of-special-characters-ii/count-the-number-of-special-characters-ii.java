class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        Map<Character,Integer> small = new HashMap<>();
        Map<Character,Integer> capital = new HashMap<>();
        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(ch>='a' && ch<='z'){
                small.put(ch,i);
            }            
        }
        for(int i=0; i<n; i++){
            char ch = word.charAt(i);
            if(ch>='A' && ch<='Z'){
                if(!capital.containsKey(ch)) capital.put(ch,i);
            }
        }
        int count = 0;
        for(char ch : small.keySet()){
            char ch1 = Character.toUpperCase(ch);
            if(capital.containsKey(ch1)){
                if(capital.get(ch1) > small.get(ch)) count++;
            }
        }
        return count;
    }
}