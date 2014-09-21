public class Driver {
    public static void main(String[] args){
	String s = "johnny so";
	String firstName = s.substring(0, s.indexOf( ' ' ));
	String lastName = s.substring(s.indexOf( ' ' )+1);
	System.out.println( s );
	System.out.println( firstName );
	System.out.println( lastName );
    }
}
