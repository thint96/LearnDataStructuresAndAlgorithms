package spoj.DIVSUM;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * #number-theory
 * 
 * Given a natural number n (1 <= n <= 500000), please output the summation of all its proper divisors.
 * Definition: A proper divisor of a natural number is the divisor that is strictly less than the number.
 * e.g. number 20 has 5 proper divisors: 1, 2, 4, 5, 10, and the divisor summation is: 1 + 2 + 4 + 5 + 10 = 22.
 *
 * Input:
 * An integer stating the number of test cases (equal to about 200000),
 * and that many lines follow, each containing one integer between 1 and 500000 inclusive.
 * 
 * Output:
 * One integer each line: the divisor summation of the integer given respectively.
 * 
 * Example:
 * Sample Input:
 * 3
 * 2
 * 10
 * 20
 * 
 * Sample Output:
 * 1
 * 8
 * 22
 * 
 * Giải thuật:
 * Cho một biến chạy từ 1 đến căn bậc 2 của n 
 * (có một tính chất là một số là số nguyên tố khi nó không chia hết cho bất cứ số nào nằm trong khoảng 
 * từ 1 cho đến căn bậc 2 của nó)
 * Giả sừ 20 thì chỉ chạy từ 1 đến 4 
 * chạy đến 1 sẽ được cặp số (1, 20), 
 * chạy đến 2 thì sẽ có cặp số (2, 10), 
 * chạy đến 3 không có cặp số nào vì 20 không chia hết cho 3, 
 * chạy đến 4 thì sẽ có cặp số (4, 5). 
 * Tính tổng các cặp số này nhớ loại đi số 20 vì đề bài yêu cầu các ước số phải nhỏ hơn chính nó. 
 * Ngoại lệ:
 * Giả sử số là 9 thì sẽ chạy từ 1 đến 3 sẽ thu đc các cặp số (1, 9), (3, 3) 
 * đáp số chỉ là 4 nên hãy chắc chắn 3 không được tính 2 lần.
 */

public class DIVSUM_DivisorSummation 
{
	public static void main(String[] args) throws Exception
	{
		System.setIn(new FileInputStream("/media/thanhthi/Entertainment/onThiSSTuCode/OnThiSS/src/spoj/DIVSUM/input.txt"));
		Scanner scanner = new Scanner(System.in);
		
		int numberTestCase = scanner.nextInt();
		for (int i = 0; i < numberTestCase; i++)
		{
			int a = scanner.nextInt();
			int temp = (int) Math.sqrt(Double.parseDouble(a + ""));
			int sum = 0;
			
			if (a > temp)
			{
				sum = 1;
				for (int j = 2; j <= temp; j++)
				{
					if (a % j == 0)	
					{	
						int k = a / j;
						if (j == k)
						{
							sum += j;
						}
						else
						{
							sum += (j + k);
						}
					}
				}
			}
			
			System.out.println(sum);
		}
	}
}
