public class Driver{

    public static void main(String[] args){

	String[] test = {"hello","abcd","xylophone","elephant","moshimoshi"};

	SarrayStr s = new SarrayStr(100, test);
	System.out.println(s);

	System.out.println();

	OrderedSuperArray o = new OrderedSuperArray(100, test);
	System.out.println(o);
	o.add("pineapple");
	System.out.println(o);
	o.add("pinapple");
	System.out.println(o);
	o.add("pie");
	System.out.println(o);
	o.set(2, "cat");
	System.out.println(o);
	o.set(4, "dog");
	System.out.println(o);
	System.out.println(o.size());
    }

}
