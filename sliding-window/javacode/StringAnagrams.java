package javacode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class StringAnagrams {

    public static List<Integer> findStringAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        HashMap<Character, Integer> pFreqMap = new HashMap<>();
        int wStart = 0, wEnd = 0, matched = 0;
        // Populate a pattern frequency map
        for (char c : p.toCharArray())
            pFreqMap.put(c, pFreqMap.getOrDefault(c, 0) + 1);

        for (; wEnd < s.length(); wEnd++) {
            char rightChar = s.charAt(wEnd);
            if (pFreqMap.containsKey(rightChar)) {
                pFreqMap.put(rightChar, pFreqMap.get(rightChar) - 1);
                if (pFreqMap.get(rightChar) == 0)
                    matched++;
            }

            if (matched == pFreqMap.size())
                result.add(wStart);

            if (wEnd >= p.length() - 1) {
                char leftChar = s.charAt(wStart);
                wStart++;
                if (pFreqMap.containsKey(leftChar)) {
                    if (pFreqMap.get(leftChar) == 0)
                        matched--;

                    pFreqMap.put(leftChar, pFreqMap.get(leftChar) + 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ppqp";
        String p = "pq";
        List<Integer> result = findStringAnagrams(s, p);
        System.out.println("Contains: " + result); // Contains: [1, 2]

        s = "odicf";
        p = "dc";
        result = findStringAnagrams(s, p);
        System.out.println("Contains: " + result); // Contains: []

        s = "abbcabc";
        p = "abc";
        result = findStringAnagrams(s, p);
        System.out.println("Contains: " + result); // Contains: [2, 3, 4]

    }
}
