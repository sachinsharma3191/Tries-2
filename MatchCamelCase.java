import java.util.*;

//Time Complexity : O(M ( N + L))  M = Length of Queries,N = Size of Pattern,L = Size of Each Query 
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/*
 * For each string, matth it with the pattern and pass the result.

The match process uses i for query pointer and j for pattern pointer, each iteration;

If current char query[i] matches pattern[j], increase pattern pointer;
if does not match and query[i] is lowercase, keep going;
if does not match and query[i] is captalized, we should return false.
If this pattern matches, j should equal length of pattern at the end.
 * 
 * 
 *  */
public class MatchCamelCase {
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> output = new ArrayList<>();
		int patternSize = pattern.length();
		for (String query : queries) {
			int i = 0;
			boolean flag = false;
			int size = query.length();
			for (int j = 0; j < size; j++) {
				char ch = query.charAt(j);
				if (i < patternSize && ch == pattern.charAt(i)) {
					i++;
					if (i == patternSize) {
						flag = true;
					}
				} else if (Character.isUpperCase(ch)) {
					flag = false;
					break;
				}
			}
			output.add(flag);
		}
		return output;
	}
}