public class IXLQ2 {

	/**
	 * QUESTION #2:
	 
		// The following Java code is responsible for creating an HTML "SELECT"
		// list of U.S. states, allowing a user to specify his or her state. This might
		// be used, for instance, on a credit card transaction screen. 
		//
		// Please rewrite this code to be "better". Submit your replacement code, and
		// please also submit a few brief comments explaining why you think your code
		// is better than the sample.
		//
		// (For brevity, this sample works for only 5 states. The real version would
		// need to work for all 50 states. But it is fine if your rewrite shows only
		// the 5 states here.)
	 */
	
	/* Switch statement gives better performance than if statement
	 * In case of String label, compiler produces a hash table, so the looks up is O(1)
	 * And, this is memory saving since you don't need to save states in a hash,
	 * they produce it during runtime and then garbage collector will deal with it
	 */
	
	//Author: Fengrui Yang
	
	public class StateUtils {
		
  		//
  		// Generates an HTML select list that can be used to select a specific
  		// U.S. state.
  		//
  		public String createStateSelectList()
  		{
    	return
      		"<select name=\"state\">\n"
    		+ "<option value=\"Alabama\">Alabama</option>\n"
    		+ "<option value=\"Alaska\">Alaska</option>\n"
    		+ "<option value=\"Arizona\">Arizona</option>\n"
    		+ "<option value=\"Arkansas\">Arkansas</option>\n"
    		+ "<option value=\"California\">California</option>\n"
    		// more states here
    		+ "</select>\n"
    		;
  		}

  		//
  		// Parses the state from an HTML form submission, converting it to
  		// the two-letter abbreviation. We need to store the two-letter abbreviation
  		// in our database.
  		//
  		public String parseSelectedState(String s)
  		{
  			String tmp = null;
  			switch(s){
  				case "Alabama": tmp = "AL"; break;
  				case "Alaska": tmp = "AK"; break;
  				case "Arizona": tmp = "AZ"; break;
  				case "Arkansas": tmp = "AR"; break;
  				case "California": tmp = "CA"; break;
  				default: tmp = "Null"; break;
  				// more states here
  			}
  			return tmp;
  		}

  		//
  		// Displays the full name of the state specified by the two-letter code.
  		//
  		public String displayStateFullName(String abbr) {
  			String tmp = null;
  			switch(abbr){
  				case "AL": tmp = "Alabama"; break;
  				case "AK": tmp = "Alaska"; break;
  				case "AZ": tmp = "Arizona"; break;
  				case "AR": tmp = "Arkansas"; break;
  				case "CA": tmp = "California"; break;
  				default: tmp = "Null"; break;
  				// more states here
  			}
  			return tmp;
  		}

  	}
}
