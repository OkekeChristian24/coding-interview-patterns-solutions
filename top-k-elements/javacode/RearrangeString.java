
package javacode;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.HashMap;

/**
 * RearrangeString
 */
public class RearrangeString {

    public static String rearrangeString(String str) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        // Populate the freq of each char in the string
        for (char c : str.toCharArray())
            charFreqMap.put(c, charFreqMap.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        StringBuffer newStr = new StringBuffer();

        // Adds char-freq key-value pairs to the max heap
        maxHeap.addAll(charFreqMap.entrySet());

        Map.Entry<Character, Integer> prevEntry = null;
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> currEntry = maxHeap.poll();
            // If previously removed char is still remaining, add it
            // back to the heap
            if (prevEntry != null && prevEntry.getValue() > 0)
                maxHeap.offer(prevEntry);

            newStr.append(currEntry.getKey());
            currEntry.setValue(currEntry.getValue() - 1);
            prevEntry = currEntry;
        }

        return newStr.length() != str.length() ? "" : newStr.toString();
    }

    public static void main(String[] args) {
        String str = "Programming";
        System.out.println("Rearranged " + str + ": " + rearrangeString(str));

        str = "aapa";
        System.out.println("Rearranged " + str + ": " + rearrangeString(str));

    }
}