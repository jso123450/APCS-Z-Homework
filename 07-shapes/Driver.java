public class Driver {
    public static void  main(String[] args){
	Shapes s =  new Shapes();
	// Testing HW 7, Shapes, Part I
	System.out.println(s.box(5,4));
	System.out.println(s.box(4,5));
	System.out.println(s.tri1(4));
	System.out.println("\n");
	System.out.println(s.tri2(4));

	// Testing methods done in class using for loops
	System.out.println(s.tri1v2(5));
	System.out.println(s.tri2v2(5));

	// Testing HW 7B, Shapes, Part II
	System.out.println(s.tri3(4));
	System.out.println(s.diamond(5));
	System.out.println(s.diamond(4));
	System.out.println(s.tri4(4));
    }
}
