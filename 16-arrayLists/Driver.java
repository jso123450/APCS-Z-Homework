import java.util.*;

public class Driver{

    public static void main(String[] args){
	ArrayList<String> al;
	al = new ArrayList<String>();
	System.out.println(al);
	al.add("hello");
	System.out.println(al);
	al.add("world");
	System.out.println(al);
	al.add("33.2");
	System.out.println(al);

	ArrayList<Integer> ai = new ArrayList<Integer>();
	Random r = new Random();
	for (int i = 0; i < 20; i++){
	    ai.add(r.nextInt(3));;
	}
	System.out.println(ai);
	System.out.println();
	// remove duplicates
	int holder = ai.get(0);
	int i = 1;
	while (i < ai.size()){
	    // incorporated try and catch blocks to account for a consecutive
	    // series of equal ints located at the end of the list so it would
	    // not crash
	    try {
		while (holder == ai.get(i))
		    ai.remove(i);
		if (i != ai.size())
		    holder = ai.get(i);
	    } catch (IndexOutOfBoundsException e){
		break;
	    }
	    i++;
	}
	System.out.println(ai);
    
    }
}
