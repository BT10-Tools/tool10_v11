package tool10.util;

import tool10.underdev.LongByteSequences;

public class StrLCS {

	// Function to find the length of the longest common substring
    static int maxCommStr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int res = 0;

        // Consider every pair of index and find the length
        // of the longest common substring beginning with 
        // every pair. Finally return max of all maximums.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curr = 0;
                while ((i + curr) < m && (j + curr) < n 
                   && s1.charAt(i + curr) == s2.charAt(j + curr)) {
                    curr++;
                }
                res = Math.max(res, curr);
            }
        }
        return res;
    }
    // Returns length of the longest common substring 
    // ending with the last characters. We mainly find
    // Longest common suffix.
    static int LCSuf(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0 || s1.charAt(m - 1) 
                                  != s2.charAt(n - 1)) {
            return 0;
        }
        return 1 + LCSuf(s1, s2, m - 1, n - 1);
    }

    static int maxCommStrRecursive(String s1, String s2) {
        int res = 0;
        int m = s1.length();
        int n = s2.length();

        // Find the longest common substring ending
        // at every pair of characters and take the 
        // maximum of all.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                res = Math.max(res, LCSuf(s1, s2, i, j));
            }
        }
        return res;
    }
    // Returns length of longest common substring of 
    // s1[0..m-1] and s2[0..n-1]
    public static int maxCommStrDynamic(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a table to store lengths of longest
        // common suffixes of substrings. Note that LCSuf[i][j] 
        // is going to contain length of longest common suffix 
        // of s1[0..i-1] and s2[0..j-1].
        int[][] LCSuf = new int[m + 1][n + 1];
        int res = 0; 

        // Following steps build LCSuf[m+1][n+1] in bottom up fashion.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    LCSuf[i][j] = LCSuf[i - 1][j - 1] + 1;
                    res = Math.max(res, LCSuf[i][j]);
                } else {
                    LCSuf[i][j] = 0;
                }
            }
        }
        return res;
    }
    // Function to find the length of the longest LCS 
    // with space optimization
    public static int longestCommonSubstr(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 1D array to store the previous row's results
        int[] prev = new int[n + 1];
        
        int res = 0;
        for (int i = 1; i <= m; i++) {
          
            // Create a temporary array to store the current row
            int[] curr = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                    res = Math.max(res, curr[j]);
                } else {
                    curr[j] = 0;
                }
            }
          
            // Move the current row's data to the previous row
            prev = curr;
        }
        return res;
    }
    public static String lcs(String S1, String S2, int m, int n) {
        int[][] LCS_table = new int[m + 1][n + 1];

        // Building the mtrix in bottom-up way
        for (int i = 0; i <= m; i++) {
          for (int j = 0; j <= n; j++) {
            if (i == 0 || j == 0)
              LCS_table[i][j] = 0;
            else if (S1.charAt(i - 1) == S2.charAt(j - 1))
              LCS_table[i][j] = LCS_table[i - 1][j - 1] + 1;
            else
              LCS_table[i][j] = Math.max(LCS_table[i - 1][j], LCS_table[i][j - 1]);
          }
        }

        int index = LCS_table[m][n];
        int temp = index;

        char[] lcs = new char[index + 1];
        lcs[index] = '\0';

        int i = m, j = n;
        while (i > 0 && j > 0) {
          if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
            lcs[index - 1] = S1.charAt(i - 1);

            i--;
            j--;
            index--;
          }

          else if (LCS_table[i - 1][j] > LCS_table[i][j - 1])
            i--;
          else
            j--;
        }
        StringBuilder sb = new StringBuilder();
        // Printing the sub sequences
        //System.out.print("S1 : " + S1 + "\nS2 : " + S2 + "\nLCS: ");
        for (int k = 0; k <= temp; k++) sb.append(lcs[k]);
        return(sb.toString());
      }
    
    /** function lcs **/
    public static String lcs2(String str1, String str2)
    {
        int l1 = str1.length();
        int l2 = str2.length();
 
        int[][] arr = new int[l1 + 1][l2 + 1];
 
        for (int i = l1 - 1; i >= 0; i--)
        {
            for (int j = l2 - 1; j >= 0; j--)
            {
                if (str1.charAt(i) == str2.charAt(j))
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                else 
                    arr[i][j] = Math.max(arr[i + 1][j], arr[i][j + 1]);
            }
        }
 
        int i = 0, j = 0;
        StringBuffer sb = new StringBuffer();
        while (i < l1 && j < l2) 
        {
            if (str1.charAt(i) == str2.charAt(j)) 
            {
                sb.append(str1.charAt(i));
                i++;
                j++;
            }
            else if (arr[i + 1][j] >= arr[i][j + 1]) 
                i++;
            else
                j++;
        }
        return sb.toString();
    }
    public static String longestSubstring(String str1, String str2) {
    	 
    	StringBuilder sb = new StringBuilder();
    	if (str1 == null || str1.isEmpty() || str2 == null || str2.isEmpty())  return "";
    	 
    	// java initializes them already with 0
    	int[][] num = new int[str1.length()][str2.length()];
    	int maxlen = 0;
    	int lastSubsBegin = 0;
    	 
    	for (int i = 0; i < str1.length(); i++) {
    	for (int j = 0; j < str2.length(); j++) {
    	  if (str1.charAt(i) == str2.charAt(j)) {
    	    if ((i == 0) || (j == 0))
    	       num[i][j] = 1;
    	    else
    	       num[i][j] = 1 + num[i - 1][j - 1];
    	 
    	    if (num[i][j] > maxlen) {
    	      maxlen = num[i][j];
    	      // generate substring from str1 => i
    	      int thisSubsBegin = i - num[i][j] + 1;
    	      if (lastSubsBegin == thisSubsBegin) {
    	         //if the current LCS is the same as the last time this block ran
    	         sb.append(str1.charAt(i));
    	      } else {
    	         //this block resets the string builder if a different LCS is found
    	         lastSubsBegin = thisSubsBegin;
    	         sb = new StringBuilder();
    	         sb.append(str1.substring(lastSubsBegin, i + 1));
    	      }
    	   }
    	}
    	}}
    	 
    	return sb.toString();
    }
    public static void main(String[] args) {
    	System.out.println("Selamun Aleyküm");
    	String s1 = "geeksforgeeks";
        String s2 = "practicewritegeekscourses";
        System.out.println(maxCommStr(s1, s2));
        System.out.println(maxCommStrRecursive(s1, s2));
        System.out.println(maxCommStrDynamic(s1, s2));
        System.out.println(longestCommonSubstr(s1, s2));
        System.out.println(lcs(s1, s2, s1.length(), s2.length()));
        System.out.println(lcs2(s1, s2));
        System.out.println(longestSubstring(s1, s2));
        
        LongByteSequences lbs = new LongByteSequences(s1.getBytes(), s2.getBytes(), 3, 4);
        
        lbs.compareByteInByte(3);
        
        
    }
	   
}
