public class Driver{
    public static void main(String[] args){
	for (int i = 0; i < 10; i++){
	    System.out.println(new Interval());
	}
	/* this works because printStuff is static -- it belongs to the
	   class and is created with the class (not with instances)
	   We can call it without instantiating an Interval, because
	   we're already in the class
	   printStuff();
	*/
	Interval.printStuff(); // calling off the class, like Math.sqrt
	Interval x = new Interval();
	x.printStuff(); // but we can also call it off of an instance

	Interval[] a = new Interval[10];
	for (int i = 0; i < a.length; i++){
	    a[i] = new Interval();
	}
	System.out.println(Arrays.toString(a));

	String[] sa = {"frog","toad","iguana","kimodo dragon","bearded lizard"};
	System.out.println(Arrays.toString(sa));
	Arrays.sort(sa);
	System.out.println(Arrays.toString(sa));

	System.out.println(Arrays.toString(a));
	Arrays.sort(a);
	System.out.println(Arrays.toString(a));
    }
}
