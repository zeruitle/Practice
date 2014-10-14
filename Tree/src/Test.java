
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//for (int i = 0; i < 100 ; i++){
		//System.out.println(i+" "+ifPow2(i));}
		System.out.println(parity(null));

	}
	
	public static int factorial(int input){
		int result = 1;
		for (int i = 1; i <= input; i++){
			result = result * i;
		}
		return result;
	}
	
	//input = n where n!
	public static int trailing(int input){
		int result = 0;
		for(int i = 1; Math.pow(5,i) < input; i++ ){
			result = result + (int) (input/Math.pow(5,i));
		}
		return result;
	}
	
	public static boolean ifPow2(int value){
		return (value != 0 && (value & -value) == value);
	}
	
	public static String parity(String msg){
		if(msg!=null){
		String parityStr = null;
		int n = msg.hashCode();
		System.out.println(n);
		switch(n%2)
		{
			case 0:
				parityStr = "even";
				break;
			case 1:
				parityStr = "odd";
				break;
		}
		return parityStr;} else
			return "no input";
	}

}
