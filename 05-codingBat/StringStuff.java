public class StringStuff {

    public String nonStart(String a, String b){
	// omit the first characters of each string assuming
	// the length of each string is at least 1
	return a.substring(1) + b.substring(1);
    }
    
    public String makeABBA(String a, String b){
	// returns a string that repeats ABBA
	return a+b+b+a;
    }
    
    public int diff21(int n){
	// solves this function by expressing it as a piecewise function
	// if n > 21, then its twice the difference between n and 21
	// if n < 21, then its 21 - n
	if (n > 21) return 2*(n-21);
	else return 21-n;
    }

    public void test1(){
	// Testing nonStart
	System.out.println("nonStart");
	System.out.println("nonStart('Hello', 'There') = " + nonStart("Hello","There"));
	System.out.println("nonStart('java', 'code') = " + nonStart("java","code"));
	System.out.println("nonStart('x', 'y') = " + nonStart("x","y"));

	// Testing makeABBA
	System.out.println("makeABBA");
	System.out.println("makeABBA('Hi', 'Bye') = " + makeABBA("Hi", "Bye"));
	System.out.println("makeABBA('x', '') = " + makeABBA("x", ""));
	System.out.println("makeABBA('', 'y') = " + makeABBA("", "y"));

	// Testing diff21
	System.out.println("diff21");
	System.out.println("dif21(-2) = " + diff21(-2));
	System.out.println("dif21(50) = " + diff21(50));
	System.out.println("dif21(21) = " + diff21(21));
	System.out.println("dif21(0) = " + diff21(0));
    }

}
