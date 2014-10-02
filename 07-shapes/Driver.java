
public class Driver {
    public static void  main(String[] args){
	Shapes s =  new Shapes();
	System.out.println(s.box(5,4));
	System.out.println(s.box(4,5));
	System.out.println(s.tri1(4));
	System.out.println("\n");
	System.out.println(s.tri2(4));

	// Testing methods done in class using for loops
	System.out.println(s.tri1v2(5));
	System.out.println(s.tri2v2(5));
    }
}
