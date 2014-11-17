import java.util.*;

public class Arrays{
    
    private Random rnd = new Random();
    private int[] ai;

    public Arrays(){
	this(10);
    }

    public Arrays(int n){
	ai = new int[n];
	for (int i = 0; i < n; i++){
	    ai[i] = i;
	}
    }

    public String toString(){
	String output = "[";
	for (int i = 0; i < ai.length; i++){
	    if (i == ai.length - 1)
		output+= ai[i] + "]";
	    else
		output+= ai[i] + ", ";
	}
	return output;
    }

    public void randomizeA(){
	// creates a new Arrays named copy exactly the same as the original
        Arrays copy = new Arrays(this.ai.length);
	// creates a new array of Strings, all filled with "n"
	String[] check = new String[this.ai.length];
	for (int i = 0; i < check.length; i++){
	    check[i] = "n";
	}
	for (int i = 0; i < this.ai.length; i++){
	    int r = rnd.nextInt( check.length );
	    // if the number has already been used, subtract 1 from i
	    // so the loop runs for the same i until it hits an "n"
	    if (check[r] == "y")
		i--;
	    // if the number hasn't been used yet, just substitute
	    // the element in the original at index i with the new random index
	    // in the copy
	    else {
		this.ai[i] = copy.ai[r];
		check[r] = "y";
	    }
	}
    }

    public static void main(String[] args){
	Arrays a = new Arrays();
	System.out.println(a);
	a.randomizeA();
	System.out.println(a);
    }
}
