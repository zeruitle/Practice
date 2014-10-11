
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ifPow2(2));

	}
	
	public static boolean ifPow2(int value){
		return ((value & -value) == value);
	}

}
