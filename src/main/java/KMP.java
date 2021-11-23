import java.util.Arrays;

public class KMP {
    static StringBuilder KMPSearch(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();
        StringBuilder result = new StringBuilder();
        int[] patternArray = createPrefixArray(pattern, patternLength);

        int i = 0;
        int j = 0;
        while (i < textLength) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == patternLength) {
                result.append("Found pattern at index ").append(i - j).append("\n");
                j = patternArray[j - 1];
            } else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = patternArray[j - 1];
                else
                    i = i + 1;
            }
        }
        return result;
    }

    static int[] createPrefixArray(String pattern, int patternLength) {
        int[] prefixArray = new int[patternLength];
        int len = 0;
        int i = 1;
        prefixArray[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                prefixArray[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = prefixArray[len - 1];
                } else {
                    prefixArray[i] = len;
                    i++;
                }
            }
        }
        return prefixArray;
    }
}