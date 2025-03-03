/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Stefan Perkovic
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */
    public static int longestSharedSubstring(String doc1, String doc2) {
        // Creates 2D array to store the longest subsequences at given indexes
        int[][] arr = new int[doc1.length() + 1][doc2.length() + 1];

        // Nested for loop to go over every character pair in the array
        for (int i = 1; i <= doc1.length(); i++){
            for (int j = 1; j <= doc2.length(); j++){
                // Checks if the two characters are equal
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    // Goes diagonally before and adds one to that value
                    arr[i][j] = arr[i - 1][j - 1] + 1;
                }
                // Take the maximum value from the top or left cell
                else{
                    if (arr[i][j - 1] > arr[i - 1][j]){
                        arr[i][j] = arr[i][j - 1];
                    }
                    else{
                        arr[i][j] = arr[i- 1][j];
                    }
                }
            }
        }
        // Returns the length of the longest common subsequence
        return arr[doc1.length()][doc2.length()];
    }
}