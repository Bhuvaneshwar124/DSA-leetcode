// import java.util.BitSet;
class Solution {
    public int numberOfSpecialChars(String word) {
        BitSet bitsA=new BitSet(26);
        BitSet bitsb=new BitSet(26);
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(c>='a')bitsb.set((int)c-'a');
            else bitsA.set((int)c-'A');
        }
        bitsA.and(bitsb);
        return bitsA.cardinality();
    }
}