public class OperatorTest {
	public static void main(String[] args) {
		int num1 = 7;
		int num2 = 3;
		System.out.println("num1 / num2 = " + (num1 / num2));
		System.out.println("num1 / num2 = " + (7.0 / 3.0));
		
//		num1 += num2; 	// num1 = num1 + num2
						// num1 = 7 + 3

		num1 %= num2;	// num1 = num1 % num2
						// num1 = 7 % 3
		
		System.out.println(num1); 
		System.out.println(num2);
	}
}
