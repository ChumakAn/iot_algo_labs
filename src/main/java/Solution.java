import java.util.ArrayList;

public class Solution {

    private static Integer[] findPossibleSquares(String binaryString, int number) {
        ArrayList<Integer> listOfSquares = new ArrayList<>();
        String length = "";
        for (int i = 0; length.length() < binaryString.length(); i++) {
            int numberPow = (int) Math.pow(number, i);
            listOfSquares.add(numberPow);
            length = Integer.toBinaryString(numberPow);
        }
        Integer[] arrayOfPows = new Integer[listOfSquares.size()];
        arrayOfPows = listOfSquares.toArray(arrayOfPows);

        return arrayOfPows;
    }

    private static int findQuantityOfBinaryPows(String binaryString, Integer[] listOfSquares) {
        int answer = 0;
        String binarySquare = "";
        char[] binaryToChars = binaryString.toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        String stringToCompare = "";
        for (int i = 0; i < binaryToChars.length; i++) {
            stringBuilder.append(binaryToChars[i]);
            stringToCompare = stringBuilder.toString();
            for (int j = 0; j < listOfSquares.length; j++) {
                if (stringToCompare.equals(Integer.toBinaryString(listOfSquares[j])) && !(stringToCompare.equals("1"))) {
                    System.out.println(stringBuilder);
                    answer++;
                    stringBuilder = new StringBuilder();
                }
            }
        }
        if (stringToCompare.equals("1"))
            answer++;
        return answer;

    }

    public static int findSolution(String binaryString, int number) {
        Integer[] arrayOfPows = findPossibleSquares(binaryString, number);
        int answer = findQuantityOfBinaryPows(binaryString, arrayOfPows);
        return answer;
    }

    public static void main(String[] args) {

    }

}

