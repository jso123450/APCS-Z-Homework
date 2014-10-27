import java.util.*;

public class ArrayStuff {

    /*--------------------------Instance Variables---------------------------*/
    
    private int[] a;

    Random rnd;

    // By making x final, we can set it once, but then never change it
    // private final int x = 123;

    /*---------------------------Constructors--------------------------------*/

    public ArrayStuff(){
        this(100);
    }

    public ArrayStuff(int n){
	rnd = new Random();
	a = new int[n];
	for (int i = 0; i < a.length; i++){
	    a[i] = 75 + rnd.nextInt(76);
	}
    }

    /*--------------------------------Methods--------------------------------*/
    
    public String toString(){
	String s = "";
	// this is invalid because x is declared to be final (cannot be changed)
	// x = 321;
	for (int i = 0; i < a.length; i++){
	    s = s + a[i] + ", ";
	}
	return s;
    }

    public int find(int n){
	int output = -1;
	for (int i = 0; i < a.length; i++){
	    if (a[i] == n){
		output = i;
		i = a.length;
	    }
	}
	return output;
    }

    public int maxVal(){
	int output = 0;
	for (int i = 0; i < a.length; i++){
	    if (a[i] > output){
		output = a[i];
	    }
	}
	return output;
    }

    /*-----------------------------Main Method-------------------------------*/
    
    public static void main(String[] args){
	ArrayStuff as = new ArrayStuff();
	System.out.println(as);
	System.out.println();
	System.out.println( as.find(100) );
	System.out.println();
	System.out.println( as.maxVal() );
    }

}
