public class Driver {

    public static void main(String[] args){

	public boolean mixStart(String s) {
	    // if the length of the string is too short, immediately return false
	    if ( s.length() < 3 ) return false;
	    // set s1 equal to the two characters after the first in the string
	    String s1 = s.substring(1,3);
	    // check if s1 is equal in value to "ix"
	    return s1.equals("ix");
	}

	public String makeOutWord(String o, String w){
	    // this chops the o string in half, adds the w string into it, and then closes it with the second
	    // half of the o string
	    String output = o.substring(0, o.length()/2) + w + o.substring(o.length()/2);
	}

	public String firstHalf(String s){
	    // this chops string s in half
	    s1 = s.substring(0, s.length()/2 ); 
	}

    }
}
