package javacode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;
// import java.util.List;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a string and a number ‘K’, find if the string can be rearranged such
 * that the same characters are at least ‘K’ distance apart from each other.
 * 
 * Example 1:
 * Input: "mmpp", K=2
 * Output: "mpmp" or "pmpm"
 * Explanation: All same characters are 2 distance apart.
 * 
 * Example 2:
 * Input: "Programming", K=3
 * Output: "rgmPrgmiano" or "gmringmrPoa" or "gmrPagimnor" and a few more  
 * Explanation: All same characters are 3 distance apart.
 * 
 * Example 3:
 * Input: "aab", K=2
 * Output: "aba"
 * Explanation: All same characters are 2 distance apart.
 * 
 * Example 4:
 * Input: "aappa", K=3
 * Output: ""
 * Explanation: We cannot find an arrangement of the string where any two 'a' are 3 distance apart.
 */
public class RearrangeStringKDistanceApart {

    public static String reorganiseString(String str, int k) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c : str.toCharArray())
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());
        maxHeap.addAll(charFreqMap.entrySet());

        StringBuilder newStr = new StringBuilder();
        Queue<Map.Entry<Character, Integer>> queue = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> strEntry = maxHeap.poll();

            newStr.append(strEntry.getKey());
            strEntry.setValue(strEntry.getValue() - 1);
            queue.offer(strEntry);

            if (queue.size() >= k) {
                Map.Entry<Character, Integer> entry = queue.poll();
                if (entry.getValue() > 0)
                    maxHeap.offer(entry);

            }
        }
        // System.out.println(newStr.toString());

        return newStr.length() != str.length() ? "" : newStr.toString();

    }

    public static void main(String[] args) {
        String str = "Programming";
        int k = 3;
        System.out.println("Rearranged " + str + ": " + reorganiseString(str, k)); // Rearranged Programming:
                                                                                   // rgmPrgmiano

        str = "aab";
        k = 2;
        System.out.println("Rearranged " + str + ": " + reorganiseString(str, k)); // Rearranged aab: aba

        str = "mmpp";
        k = 2;
        System.out.println("Rearranged " + str + ": " + reorganiseString(str, k)); // Rearranged mmpp: pmpm

        str = "aappa";
        k = 3;
        System.out.println("Rearranged " + str + ": " + reorganiseString(str, k)); // Rearranged aappa:

    }
}
