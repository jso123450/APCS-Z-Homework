public class StringStuff {

    // frontTimes took me about 4 minutes
    // it took me around 2 minutes to do the essential and then
    // the rest of the time was dedicated to fixing the error I had made when
    // trying to intitialzie a new String front inside the if/else statements

    public String frontTimes(String str, int n){
	String front = "";
	if (str.length() <= 3){
	    front = front + str;
	}
	else {
	    front = front + str.substring(0, 3);
	}
	String output = "";
	while (n > 0) {
	    output = output + front;
	    n = n - 1;
	}
	return output;
    }

    // stringBits took me ~1 minute
    public String stringBits(String str){
	int c = 0;
	String output = "";
	while (c < str.length()){
	    output = output + str.substring(c, c+1);
	    c = c + 2;
	}
	return output;
    }

    // stringYak took me ~3 mins because I didn't notice that I had forgotten the c = c + 1; 
    // line when trying it in codingBat

    public String stringYak(String str){
	String output = "";
	int c = 0;
	while (c < str.length()) {
	    if (c + 2 < str.length() && str.charAt(c) == 'y' && str.charAt(c+2) == 'k') {
		c = c + 2;
	    }
	    else {
		output = output + str.charAt(c);
	    }
	    c = c + 1;
	}
	return output;
    }

    // stringMatch took ~ 5 minutes

    public int stringMatch(String a, String b) {
	int l = Math.min(a.length(), b.length());
	int output = 0;
	int c = 0;
	while ( c < l - 1) {
	    String a1 = a.substring(c, c+2);
	    String b1 = b.substring(c, c+2);
	    if (a1.equals(b1)) {
		output = output + 1;
	    }
	    c = c + 1;
	}
	return output;
    }

    // Test Method

    public void test(){

	// Testing frontTimes
	System.out.println( "Testing frontTimes" );
	System.out.println( "frontTimes( '', 4) -> " + frontTimes( "", 4) );
	System.out.println( "frontTimes( 'Chocolate', 3) -> " + frontTimes( "Chocolate", 3) );
	
	// Testing stringBits
	System.out.println( "Testing stringBits" );
	System.out.println( "stringBits( '' ) -> " + stringBits( "" ) );
	System.out.println( "stringBits( 'Heeololeo' ) -> " + stringBits( "Heeololeo" ) );

	// Testing stringYak
	System.out.println( "Testing stringYak" );
	System.out.println( "stringYak( 'yak' ) -> " + stringYak( "yak" ) );
	System.out.println( "stringYak( 'xxxyakyyyakzzz' ) -> " + stringYak( "xxxyakyyyakzzz" ) );
	
	// Testing stringMatch
	System.out.println( "Testing stringMatch" );
	System.out.println( "stringMatch('xxcaazz', 'xxbaaz') -> " + stringMatch("xxcaazz", "xxbaaz") );
	System.out.println( "stringMatch('iaxxai', 'aaxxaaxx') -> " + stringMatch("iaxxai", "aaxxaaxx") );

    }

}
