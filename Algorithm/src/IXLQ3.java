import java.util.ArrayList;


public class IXLQ3 {

	/**
	 * QUESTION #3:

		Write a Java method with the following method signature that takes a String and
		returns a String formatted so that it satisfies the requirements below.  It may
		need to insert newlines and/or delete spaces.
	
		Method Signature:
		public static String wrapText(String text, int maxCharsPerLine)

		Definitions and Assumptions:
		A word is a sequence of characters that contains no spaces and no newlines.
		Lines in the return String are separated by the newline character, '\n'.
		Words on each line are separated by spaces. Assume that the String argument does
		not contain any whitespace characters other than spaces and newlines.

		Requirements:
		1. Each line in the return String has at most maxCharsPerLine characters.
		2. Lines in the return String are not shorter than necessary. In other words, if
		an additional word would fit on a line, then it should go on that line.
		3. When constructing the return String from the String argument, each word in the 
		String argument with at most maxCharsPerLine characters should not be broken up. 
		Each word in the String argument with more than maxCharsPerLine characters should 
		be broken up so that all of the other requirements are satisfied.
		4. Newlines in the String argument are preserved.
		5. Words in the return String are separated by either a single space or by one or
		more newlines.
		6. Lines in the return String do not start or end with any spaces.
	 */
	
	//Author: Fengrui Yang
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eusmod tempor incididunt ut labore et dolore magna aliqua.";
		String input2 = "abcdeabcdeabcdeabcde dsdasd adasdas";
		System.out.println(wrapText(input,5));
		//System.out.println(overSize("abcde",3)[0]+" "+overSize("abcde",3)[1]);
		wrapText(input2,5);
	}
	
	/*
	 * Max chars per line: 20

		Input: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eusmod tempor incididunt ut labore et dolore magna aliqua."
		Output: "Lorem ipsum dolor\nsit amet,\nconsectetur\nadipisicing elit,\nsed do eusmod tempor\nincididunt ut labore\net dolore magna\naliqua."
	 */
	
	public static String wrapText(String text, int maxCharsPerLine){
		String[] strArray = preprocess(text,maxCharsPerLine);
		String result = "";
		int linelength = 0;
		/*if(strArray[0].length() > maxCharsPerLine){
			result = result + overSize(strArray[0],maxCharsPerLine)[0];
			linelength = Integer.parseInt(overSize(strArray[0],maxCharsPerLine)[1]) + 1;
		} else {*/
			result = strArray[0];
			linelength = strArray[0].length()+1;
		//}
		for(int i = 1; i < strArray.length; i++){
			if(linelength == 0){
				linelength = linelength + strArray[i].length() + 1;
				result = result + strArray[i];
			} else if(strArray[i].length()+linelength < maxCharsPerLine){
				linelength = linelength + strArray[i].length() + 1;
				result = result +" "+ strArray[i];
			} else /*if(strArray[i].length() > maxCharsPerLine) {
				result = result + overSize(strArray[i],maxCharsPerLine)[0];
				linelength = Integer.parseInt(overSize(strArray[i],maxCharsPerLine)[1]) + 1;
			} else */if(strArray[i].length()+linelength > maxCharsPerLine){
				linelength = strArray[i].length() +1;
				result = result +"\n"+ strArray[i];
			} else if(strArray[i].length()+linelength == maxCharsPerLine){
				linelength = 0;
				result = result +" "+ strArray[i]+"\n";
			} 
		}
		return result;
	}
	
	//preprocess string array to ensure no word is larger than maxChar
	public static String[] preprocess(String input, int maxCharsPerLine){
		String[] strArray = input.split("\\s+");
		ArrayList<String> tmp = new ArrayList<String>();
		for(int i = 0; i < strArray.length; i++){
			if(strArray[i].length() < maxCharsPerLine){
				tmp.add(strArray[i]);
			} else {
				int oversize = strArray[i].length() / maxCharsPerLine;
				int j = 0;
				for (j = 0; j < oversize; j++){
					tmp.add(strArray[i].substring(j*maxCharsPerLine,(j+1)*maxCharsPerLine));
				}
				if(j*maxCharsPerLine != strArray[i].length())
					tmp.add(strArray[i].substring(j*maxCharsPerLine,strArray[i].length()));
			}
		}
		String[] result = new String[tmp.size()];
		result = tmp.toArray(result);
		return result;
	}
	
	/*no use anymore
	public static String[] overSize(String input, int maxCharsPerLine) {
		int oversize = input.length() / maxCharsPerLine;
		String[] result = new String[2];
		result[0] = input.substring(0,maxCharsPerLine);
		int i = 1;
		for (i = 1; i < oversize; i++){
			result[0] = result[0] + "\n" + input.substring(i*maxCharsPerLine,(i+1)*maxCharsPerLine);
		}
		result[0] = result[0] + "\n" + input.substring(i*maxCharsPerLine,input.length());
		result[1] = ""+(input.length() - i*maxCharsPerLine);
		return result;
	}
	*/

}
