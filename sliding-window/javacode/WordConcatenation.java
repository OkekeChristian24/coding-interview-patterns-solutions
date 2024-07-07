package javacode;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class WordConcatenation {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> wordsFreq = new HashMap<>();
        int wordsCount = words.length, wordLength = words[0].length();

        // Populate the wordsFreq map
        for (String w : words)
            wordsFreq.put(w, wordsFreq.getOrDefault(w, 0) + 1);

        for (int i = 0; i <= s.length() - (wordsCount * wordLength); i++) {
            HashMap<String, Integer> wordsSeen = new HashMap<>();
            for (int j = 0; j < wordsCount; j++) {
                int nextWordIndex = i + (j * wordLength);
                String word = s.substring(nextWordIndex, nextWordIndex + wordLength);
                // Ignore word if it is not among words array
                if (!wordsFreq.containsKey(word))
                    break;

                wordsSeen.put(word, wordsSeen.getOrDefault(word, 0) + 1);

                // Ignore word if it is not necessary
                if (wordsSeen.get(word) > wordsFreq.get(word))
                    break;

                if (j + 1 == wordsCount)
                    result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[] { "foo", "bar" };
        List<Integer> result = findSubstring(s, words);
        System.out.println(result); // [0,9]

        // s = "wordgoodgoodgoodbestword";
        // words = new String[] { "word", "good", "best", "word" };
        // result = findSubstring(s, words);
        // System.out.println(result); // []

        // s = "barfoofoobarthefoobarman";
        // words = new String[] { "bar", "foo", "the" };
        // result = findSubstring(s, words);
        // System.out.println(result); // [6,9,12]
    }
}