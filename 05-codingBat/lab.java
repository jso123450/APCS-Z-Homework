public class lab {

    /* working */
    public boolean nearHundred(int n){
	// check if n is within 10 of 100 or 200
	if ((Math.abs(n - 100) <= 10) || (Math.abs(n - 200) <= 10)) return true;
	return false;
    }

    /* working */
    public int teaparty(int tea, int candy){
	// if tea or candy is less than 5, party is bad
	if ((tea < 5) || (candy < 5)) return 0;
	// if tea or candy is twice or more of the other, party is great
	if ((tea >= 2*candy) || (candy >= 2*tea)) return 2;
	// else party is good
	return 1;
    }

    /* working */
    public boolean lastDigit(int a, int b, int c){
	int a1 = a % 10;
	int b1 = b % 10;
	int c1 = c % 10;
	// check if at least two of the last digits of the three numbers are equal
	if ((a1 == b1) || (b1 == c1) || (a1 == c1)) return true;
	return false;
    }

    /* working */
    public boolean mixStart(String s) {
	// if the length of the string is too short, immediately return false
	if ( s.length() < 3 ) return false;
	// set s1 equal to the two characters after the first in the string
	String s1 = s.substring(1,3);
	// check if s1 is equal in value to "ix"
	return s1.equals("ix");
    }

}
