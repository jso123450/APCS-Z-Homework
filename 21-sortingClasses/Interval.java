import java.util.Random;
import java.util.Arrays;

public class Interval{

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

    public int getLow(){
	return low;
    }

    public int getHigh(){
	return high;
    }

    public void setLow(int l){
	low = l;
    }

    public void setHigh(int h){
	high = h;
    }

    public static void printStuff(){
	System.out.println("Stuff");
    }

    public int compareTo(Interval other){
	if (this.getLow() == other.getLow()){
	    return (this.getHigh() - other.getHigh());
	}
	else
	    return (this.getLow() - other.getLow());
    }

    /* ------------------------------ Main --------------------------- */
    public static void main(String[] args){
	/*
	for (int i = 0; i < 10; i++){
	    System.out.println(new Interval());
	}
	// this works because printStuff is static -- it belongs to the
	//   class and is created with the class (not with instances)
	//   We can call it without instantiating an Interval, because
	//   we're already in the class
	printStuff();
	Interval.printStuff(); // calling off the class, like Math.sqrt
	Interval x = new Interval();
	x.printStuff(); // but we can also call it off of an instance
	*/
	Interval[] a = new Interval[10];
	for (int i = 0; i < a.length; i++){
	    a[i] = new Interval();
	}
	System.out.println(Arrays.toString(a));
	System.out.println(a[0]);
	System.out.println(a[1]);
	System.out.println(a[0].compareTo(a[1]));

	System.out.println();

	Interval i1 = new Interval(5, 10);
	//Interval i2 = new Interval(5, 10); // all test cases seem to work
	//Interval i2 = new Interval(5, 11);
	Interval i2 = new Interval(4, 10);
	System.out.println(i1.compareTo(i2));
    }

}
