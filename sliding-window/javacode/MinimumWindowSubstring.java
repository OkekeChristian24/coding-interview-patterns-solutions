package javacode;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static String findSubstring(String p, String s) {
        HashMap<Character, Integer> pFreqMap = new HashMap<>();
        for (Character c : p.toCharArray())
            pFreqMap.put(c, pFreqMap.getOrDefault(c, 0) + 1);

        int wStart = 0, wEnd = 0, matched = 0;
        int rStart = 0, minLength = s.length() + 1;
        for (; wEnd < s.length(); wEnd++) {
            char rightChar = s.charAt(wEnd);
            if (pFreqMap.containsKey(rightChar)) {
                pFreqMap.put(rightChar, pFreqMap.get(rightChar) - 1);
                if (pFreqMap.get(rightChar) >= 0)
                    matched++;
            }

            while (matched == p.length()) {
                if (minLength > (wEnd - wStart + 1)) {
                    rStart = wStart;
                    minLength = wEnd - wStart + 1;
                }

                char leftChar = s.charAt(wStart);
                wStart++;
                if (pFreqMap.containsKey(leftChar)) {
                    if (pFreqMap.get(leftChar) >= 0)
                        matched--;

                    pFreqMap.put(leftChar, pFreqMap.get(leftChar) + 1);
                }
            }
        }

        return minLength > s.length() ? "" : s.substring(rStart, rStart + minLength);
    }

    public static void main(String[] args) {
        String s = "aabdec";
        String p = "abc";
        String result = findSubstring(s, p);
        System.out.println("Smallest: " + result);

        s = "abdabca";
        p = "abc";
        result = findSubstring(s, p);
        System.out.println("Smallest: " + result);

        s = "odicf";
        p = "dc";
        result = findSubstring(s, p);
        System.out.println("Smallest: " + result);

        s = "adcad";
        p = "abc";
        result = findSubstring(s, p);
        System.out.println("Smallest: " + result);

    }
}
