package spoj.ONP;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * #stack
 * 
 * Transform the algebraic expression with brackets into RPN form (Reverse Polish Notation). 
 * Two-argument operators: +, -, *, /, ^ 
 * (priority from the lowest to the highest), brackets ( ). 
 * Operands: only letters: a,b,...,z. 
 * Assume that there is only one RPN form (no expressions like a*b*c).
 *
 * Input:
 * t [the number of expressions <= 100]
 * expression [length <= 400]
 * [other expressions]
 * Text grouped in [ ] does not appear in the input file.
 * 
 * Output:
 * The expressions in RPN form, one per line.
 * 
 * Example:
 * Input:
 * 3
 * (a+(b*c))
 * ((a+b)*(z+x))
 * ((a+t)*((b+(a+c))^(c+d)))
 * 
 * Output:
 * abc*+
 * ab+zx+*
 * at+bac++cd+^*
 */

public class ONP_TransformTheExpression 
{
	public static void main(String[] args) throws Exception
	{
		System.setIn(new FileInputStream("/media/thanhthi/Entertainment/onThiSSTuCode/OnThiSS/src/spoj/ONP/input.txt"));
		
		Scanner scanner = new Scanner(System.in);		
		int numberTestCase = scanner.nextInt();
		
		for (int testCase = 0; testCase < numberTestCase; testCase++)
		{
			String infix = scanner.next();
			String profix = convert(infix);
			System.out.println(profix);
		}
	}
	
	private static String convert(String infix)
	{
		String profix = "";
		Stack<Character> stackOperator = new Stack<>();
		char topSymbol, symbol;
		
		for (int i = 0; i < infix.length(); i++)
		{
			symbol = infix.charAt(i);
			if(isOperator(symbol))
			{
				profix += symbol;
			}
			else 
			{
				while(!stackOperator.empty() && pickOperator(stackOperator.peek(),symbol))
				{
					topSymbol = stackOperator.peek();
					stackOperator.pop();
					profix += topSymbol;
				}
				if(!stackOperator.empty() && symbol==')')
					stackOperator.pop();
				else 
					stackOperator.push(symbol);
			}
		}
		
		while(!stackOperator.empty())
		{
			topSymbol = stackOperator.peek();
			stackOperator.pop();
			profix += topSymbol;
		}
		
		return profix;
	}
	
	private static boolean pickOperator(char operatorA, char operatorB)
	{
		if (operatorA == '(') return false; // neu gap thang nay khong pop nua
		if (operatorB == '(') return false;
		if (operatorB == ')') return true;
		if (operatorA == '^' && operatorB == '^') return false;
		if (operatorA == '^') return true;
		if (operatorB == '^') return false;
		if (operatorA == '*' || operatorA == '/') return true;
		if (operatorB == '*' || operatorB == '/') return false;
		return true;
	}

	private static boolean isOperator(char ch) {
		return ch >= 'a' && ch <= 'z'; 
	}
}
