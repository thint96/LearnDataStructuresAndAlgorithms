package spoj.PRIME1;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * #number-theory
 * 
 * Peter wants to generate some prime numbers for his cryptosystem. 
 * Help him! Your task is to generate all prime numbers between two given numbers!
 * 
 * Input:
 * The input begins with the number t of test cases in a single line (t<=10). 
 * In each of the next t lines there are two numbers m and n 
 * (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.
 * 
 * Output:
 * For every test case print all prime numbers p such that m <= p <= n, 
 * one number per line, test cases separated by an empty line.
 * 
 * Example:
 * Input:
 * 2
 * 1 10
 * 3 5
 * 
 * Output:
 * 2
 * 3
 * 5
 * 7
 * 
 * 3
 * 5
 */

public class PRIME1_PrimeGenerator 
{
	public static void main(String[] args) throws Exception
	{	
		System.setIn(new FileInputStream("/media/thanhthi/Entertainment/onThiSSTuCode/OnThiSS/src/spoj/PRIME1/Input.txt"));

		Scanner scanner = new Scanner(System.in);
		int numTestcase, m, n;
		
		numTestcase = scanner.nextInt();
		
		for (int i = 0; i < numTestcase; i++)
		{
			m = scanner.nextInt();
			n = scanner.nextInt();
			
			if (m < 2) m = 2;
			
			for (int j = m; j <= n; j++)
			{
				if (j == 2 || checkPrime(j) == 0) {
					System.out.println(j);
				}
			}
			
			if (i < numTestcase - 1) {
				System.out.println();
			}
		}
	}
	
	private static int checkPrime(int number)
	{
		int i = 0;
		int temp = (int) Math.sqrt(Double.parseDouble(number + ""));
		for (i = 2; i <= temp; i++) {
			if (number % i == 0) return 1;
		}
		return 0;
	}
}
