import java.util.ArrayList;
import java.util.List;

/*
 * Question: Given a string, find all of its permutations preserving the character sequence but changing case.
 * 
 * Example 1:
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52" 
 * 
 * Example 2:
 * Input: "ab7c"
 * Output: "ab7c", "Ab7c", "aB7c", "AB7c", "ab7C", "Ab7C", "aB7C", "AB7C"
 * 
 */
public class LetterCaseStringPermutation {

    /*
     * Time complexity = O(2^N)
     * Space complexity = O(2^N)
     */
    public static List<String> permutation(String str) {
        List<String> permutations = new ArrayList<String>();
        if (str == null)
            return permutations;

        permutations.add(str);
        int strLen = str.length();

        // Step-wise loop to process all characters of the string
        for (int i = 0; i < strLen; i++) {
            int permLen = permutations.size();

            // Changing the cases of previous permutation strings
            for (int j = 0; j < permLen; j++) {
                String myStr = permutations.get(j);
                char myChar = str.charAt(i);
                if (Character.isLetter(myChar)) { // Only process letters
                    char newLetter;
                    // Switch the case of the letter
                    if (Character.isUpperCase(myChar))
                        newLetter = Character.toLowerCase(myChar);
                    else
                        newLetter = Character.toUpperCase(myChar);

                    String newStr = myStr.substring(0, i) + newLetter + myStr.substring(i + 1);
                    permutations.add(newStr);
                }
            }
        }
        return permutations;
    }

    /*
     * Time complexity = O(N * 2^N)
     * Space complexity = O(N * 2^N)
     */
    public static List<String> permutation2(String str) {
        List<String> permutations = new ArrayList<String>();
        if (str == null)
            return permutations;

        permutations.add(str);
        // Process every character of the string one by one
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) { // Only process characters, skip digits
                // We will take all existing permutations and changing the letter case
                // appropriately
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    // If the current character is in upper case, change it to lower case or vice
                    // versa
                    if (Character.isUpperCase(chs[i]))
                        chs[i] = Character.toLowerCase(chs[i]);
                    else
                        chs[i] = Character.toUpperCase(chs[i]);
                    permutations.add(String.valueOf(chs));
                }
            }
        }

        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = permutation("ab7c");
        // List<String> result = permutation2("ab7c");
        System.out.println("Result: " + result); // Result: [ab7c, Ab7c, aB7c, AB7c, ab7C, Ab7C, aB7C, AB7C]
        result = permutation("ad52");
        // result = permutation2("ad52");
        System.out.println("Result: " + result); // Result: [ad52, Ad52, aD52, AD52]
    }
}
