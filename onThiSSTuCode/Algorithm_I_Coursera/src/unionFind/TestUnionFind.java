package unionFind;

import java.io.FileInputStream;
import java.util.Scanner;

import edu.princeton.cs.algs4.UF;

public class TestUnionFind {

	public static void main(String[] args) throws Exception
	{
		System.setIn(new FileInputStream("/media/thanhthi/Entertainment/onThiSSTuCode/Algorithm_I_Coursera/src/unionFind/tinyUF.txt"));
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		UF unionFind = new UF(n);
		while (scanner.hasNext())
		{
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			unionFind.union(p, q);
		}
		
		int x = 5, y = 6;
		System.out.println(unionFind.connected(x, y) ? 
				(x + " and " + y + " are connected") : 
					(x + " and " + y + " are not connected"));
		
	}

}
