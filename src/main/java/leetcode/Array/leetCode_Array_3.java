package leetcode.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetCode_Array_3 {

    //3. Longest substring without repeating characters: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

    public static int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap();
        int start = 0;
        int maxLength = 0;
        for(int end = 0; end < s.length(); end++){
            char rightChar = s.charAt(end);
            if(map.containsKey(rightChar)){
                System.out.println("map.get(): " + map.get(rightChar));
                start = Math.max(start,map.get(rightChar)+1);
            }
            map.put(rightChar,end);
            maxLength = Math.max(maxLength,end-start+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
