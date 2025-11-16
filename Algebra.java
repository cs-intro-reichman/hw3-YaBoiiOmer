// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
		// no more tests :)
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if(x2 >= 0){
			for(int i = 0; i < x2; i++){
				sum++;
			}
		}else{
			for(int i = x2; i < 0; i++){
				sum--;
			}
		}

		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int difference = x1;
		if(x2 >= 0){
			for(int i = 0; i < x2; i++){
				difference--;
			}
		} else {
			for(int i = x2; i < 0; i++){
				difference++;
			}
		}
		return difference;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if(x1 == 0 || x2 == 0) return 0;
		int product = 0;

		if(x1 > 0){
			for(int i = 0; i < x1; i++){
				product = plus(product, x2);
			}
		}else{
			for(int i = x1; i < 0; i++){
				product = minus(product, x2);
			}
		}
		return product;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if(n == 0) return 1;

		int exponentiation = x;
		
		for(int i = 0; i < minus(n, 1); i++){
			exponentiation = times(exponentiation, x);
		}

		return exponentiation;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0, multiplier = 1;

		if(x1 < 0){
			multiplier = times(multiplier, -1);
			x1 = times(x1, -1);
		}
		
		if(x2 < 0){
			multiplier = times(multiplier, -1);
			x2 = times(x2, -1);
		}

		int i = x2;
		while(i <= x1){
			result++;
			i = plus(i, x2);
		}


		return result * multiplier;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int result = div(x1, x2);

		return minus(x1, times(x2, result));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		for(int i = 0; i <= x; i++){
			int result = times(i, i);
			if(result == x) {
				return i;
			}else if(result > x){
				return i - 1;
			}

		}
		return 0;
	}	  	  
}