import java.util.*;

public class ArrayLists{

    private Random rnd = new Random();
    private ArrayList<Integer> ai = new ArrayList<Integer>();

    public ArrayLists(){
        this(10);
    }

    public ArrayLists(int n){
	for (int i = 0; i < n; i++){
	    ai.add(i);
	}
    }

    public String toString(){
	String output = "[";
	for (int i = 0; i < ai.size(); i++){
	    if (i == ai.size() - 1)
		output+= ai.get(i) + "]";
	    else
		output+= ai.get(i) + ", ";
	}
	return output;
    }

    public void randomizeAL(){
        ArrayLists copy = new ArrayLists(this.ai.size());
	for (int i = 0; i < this.ai.size(); i++){
	    // r is randomized to be used as the index of the copy
	    int r = rnd.nextInt(copy.ai.size());
	    // then the element in copy at index r is used placed in the
	    // original arraylist
	    this.ai.set(i, copy.ai.get(r));
	    copy.ai.remove(r);
	}
    }


    public static void main(String[] args){
	ArrayLists a = new ArrayLists();
	System.out.println(a);
       	a.randomizeAL();
        System.out.println(a);
    }

}
