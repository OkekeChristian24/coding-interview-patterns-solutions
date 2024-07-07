package javacode;

import java.util.HashMap;

public class StringPermutation {

    public static boolean findPermutation(String s, String p) {
        HashMap<Character, Integer> pFreqMap = new HashMap<>();
        for (Character c : p.toCharArray())
            pFreqMap.put(c, pFreqMap.getOrDefault(c, 0) + 1);

        int wStart = 0, wEnd = 0, matched = 0;
        for (; wEnd < s.length(); wEnd++) {
            char rightChar = s.charAt(wEnd);
            if (pFreqMap.containsKey(rightChar)) {
                pFreqMap.put(rightChar, pFreqMap.get(rightChar) - 1);
                if (pFreqMap.get(rightChar) == 0)
                    matched++;
            }

            if (matched == pFreqMap.size())
                return true;

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
        return false;
    }

    public static void main(String[] args) {
        String s = "oidbcaf";
        String p = "abc";
        boolean result = findPermutation(s, p);
        System.out.println("Contains: " + result); // Contains: true

        s = "odicf";
        p = "dc";
        result = findPermutation(s, p);
        System.out.println("Contains: " + result); // Contains: false

    }
}
