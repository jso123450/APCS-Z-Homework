public class Driver {

    public static void main(String[] args){

	Strings s = new Strings();

	// Testing frame
	System.out.println(s.frame(5,4));
	System.out.println(s.frame(4,5));

	// Testing stringSplosion
	System.out.println("\n");
	System.out.println(s.stringSplosion("Code"));
	System.out.println(s.stringSplosion("abc"));
	System.out.println(s.stringSplosion("x"));

	// Testing stringX
	System.out.println("\n");
	System.out.println(s.stringX("xxHxix"));
	System.out.println(s.stringX(""));
	System.out.println(s.stringX("x"));

    }

}
