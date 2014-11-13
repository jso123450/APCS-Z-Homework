import java.util.*;

public class ArrayLists{

    private Random rnd = new Random();
    private ArrayList<Integer> ai;

    public ArrayLists(){
        this(10);
    }

    public ArrayLists(int n){
	for (int i = 0; i < n; i++){
	    ai.add(i);
	}
    }

    public void randomize(){
	ArrayList<Integer> copy = ai;
	for (int i = 0; i < ai.size(); i++){
	    int r = rnd.nextInt(copy.size());
	    ai.set(i, copy.get(r));
	    copy.remove(r);
	}
    }


    public static void main(String[] args){
	ArrayLists a = new ArrayLists();
	//System.out.println(a.ai);
	//	a.randomize();
	//System.out.println(a.ai);
    }

}
