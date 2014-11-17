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

    public void randomize(){
        ArrayLists copy = new ArrayLists(this.ai.size());
	for (int i = 0; i < this.ai.size(); i++){
	    int r = rnd.nextInt(copy.ai.size());
	    System.out.println("index = " + i);
	    System.out.println("random = " + r);
	    System.out.println("copy = " + copy.ai);
	    this.ai.set(i, copy.ai.get(r));
	    copy.ai.remove(r);
	    System.out.println(this.ai);
	}
    }


    public static void main(String[] args){
	ArrayLists a = new ArrayLists();
	System.out.println(a);
       	a.randomize();
	//System.out.println(a);
    }

}
