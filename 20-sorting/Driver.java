public class Driver{

    public static void main(String[] args){
	/* All the test cases work

	OrderedSuperArray ot = new OrderedSuperArray(100, test);
	System.out.println(ot);
	ot.add("pineapple");
	System.out.println(ot);
	ot.add("pinapple");
	System.out.println(ot);
	ot.add("pie");
	System.out.println(ot);
	ot.set(2, "cat");
	System.out.println(ot);
	ot.set(4, "dog");
	System.out.println(ot);
	ot.add("phone");
	System.out.println(ot);

	System.out.println();

	OrderedSuperArray o = new OrderedSuperArray(100);
	
	if (args.length > 0){
	    System.out.println();
	    System.out.println("The OrderedSuperArray was originally:");
	    System.out.println(o);
	    for (int i = 0; i < args.length; i++){
	    	o.add(args[i]);
	    }
	    System.out.println();
	    System.out.println("After adding in your words & numbers, it now looks like:");
	    System.out.println(o);
	    System.out.println();
	}
	else {
	    System.out.println("Enter parameters to be added to an OrderedSuperArray");
	}
	*/

	String[] test =
	    {"hello","abcd","xylophone","elephant","moshimoshi","asd","mouse","keyboard",
	     "screen","border","words","quotes","string","int","double","saausage","blubber",
	     "pencil","cloud","moon","water","computer","school","network","hammer","walking",
	     "violently","mediocre","literature","chair","two","window","cords","musical",
	     "zebra","penguin","home","dog"};
	SarrayStr s = new SarrayStr(100, test);
	if (args.length == 1){
	    System.out.println(s);
	    if (args[0].equals("i"))
		s.isort();
	    else if (args[0].equals("s"))
		s.ssort();
	    else if (args[0].equals("b"))
		s.bsort();
	    System.out.println(s);
	}
	else {
	    System.out.println("Enter a sorting method: i, s or b");
	}
    }

}
