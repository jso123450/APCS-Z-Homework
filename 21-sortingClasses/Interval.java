import java.util.Random;
import java.util.Arrays;

/*
  Interfaces -> contracts (in java) that specify that a class will implement
                certain methods with certain signatures

  interface name {
    method1_signature;
    method2_signature;
    etc
  }

  method signature is: public/private return_type name(params);

  For example, the bult in Java Comparable interface looks something like this:
    interface Comparable {
      public int compareTo(Object other);
    }

  To agree to implement an interface, use "implements"
  ex:
    class myClass implements Comparable{
       // class definition here
    }

  A class can only extend one class but it can implement as many interfaces
  as it wants (separated by commas)

 */

public class Interval implements Comparable{

    /* ------------------------------ Variables --------------------------- */
    private int low, high;
    private static Random r = new Random();
    // if numIntervals not static, then each Interval would have 
    // the value of numIntervals as 1
    private static int numIntervals = 0;

    /* ------------------------------ Constructors -------------------------- */
    private void setup(int l, int h){
        high = h;
	low = l;
	numIntervals++;
    }

    public Interval(){
	int h = 1 + r.nextInt(100);
	int l = r.nextInt(h);
        setup(l, h);
    }

    public Interval(int l, int h){
	setup(l, h);
    }

    /* ------------------------------ Methods --------------------------- */  
    public String toString(){
	//String s = "Interval Number " + numIntervals + 
	//    " -> [" + low + ", " + high + "]";
	String s = "[" + low + ", " + high + "]";
        return s;
    }

    public static void printStuff(){
	System.out.println("Stuff");
    }

    public int compareTo(Object other){
	// casts the parameter other to the needed class and assign it
	// to a local variable
	Interval o = (Interval)other;
	if (this.low == o.low)
	    return (this.high - o.high);
	else
	    return (this.low - o.low);
    }

}
