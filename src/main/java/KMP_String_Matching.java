public class KMP_String_Matching {
    void KMPSearch(String pattern, String text) {
        int patternLength = pattern.length();
        int textLength = text.length();

        if (patternLength == 0){
            System.out.println("Please, enter the pattern and try again");
            return;
        }
        if (textLength == 0){
            System.out.println("The text is empty. Enter the text and try again");
            return;
        }

        int[] patternArray = createPrefixArray(pattern, patternLength);

        int i = 0;
        int j = 0;

        while (i < textLength) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == patternLength) {
                System.out.println("Found pattern at index " + (i - j));
                j = patternArray[j - 1];
            }
            else if (i < textLength && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0)
                    j = patternArray[j - 1];
                else
                    i = i + 1;
            }
        }
    }

    int[] createPrefixArray(String pattern, int patternLength) {
        int[] prefixArray = new int[patternLength];
        int len = 0;
        int i = 1;
        prefixArray[0] = 0;

        while (i < patternLength) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                prefixArray[i] = len;
                i++;
            } else
            {
                if (len != 0) {
                    len = prefixArray[len - 1];
                } else
                {
                    prefixArray[i] = len;
                    i++;
                }
            }
        }
        return prefixArray;
    }

    public static void main(String[] args) {
    }
}