package spoj.SBSTR1;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Given two binary strings, A (of length 10) and B (of length 5), 
 * output 1 if B is a substring of A and 0 otherwise.
 * 
 * Input:
 * 24 lines consisting of pairs of binary strings A and B 
 * separated by a single space.
 * 
 * Output:
 * The logical value of: 'B is a substring of A'.
 *
 * Example:
 * First two lines of input:
 * 1010110010 10110
 * 1110111011 10011
 * First two lines of output:
 * 1
 * 0
 */

public class SBSTR1_SubstringCheck {

	public static void main(String[] args) throws Exception
	{	
		System.setIn(new FileInputStream("/media/thanhthi/Entertainment/onThiSSTuCode/OnThiSS/src/spoj/SBSTR1/input.txt"));
		
		Scanner scanner = new Scanner(System.in);
		
		for (int testCase = 0; testCase < 24; testCase++)
		{
			String a = scanner.next();
			String b = scanner.next();
			
			boolean isBSubStringOfA = false;
			int lengthOfB = b.length();
			
			for (int i = 0; i < a.length() - lengthOfB; i++)
			{
				boolean isEqual = true;
				for (int j = 0; j < lengthOfB; j++)
				{
					char m = a.charAt(i+j);
					char n = b.charAt(j);
					if (m != n)
					{
						isEqual = false;
						break;
					}
				}
				
				if (isEqual) 
				{
					isBSubStringOfA = true;
					break;
				}
			}
			
			String result = isBSubStringOfA ? "1" : "0";
			System.out.println(result);
		}
	}
}
