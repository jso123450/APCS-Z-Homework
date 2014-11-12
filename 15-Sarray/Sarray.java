import java.util.*;

public class Sarray{

    // Instance Variables
    private int[] data;
    private int last;
    private Random rnd;

    // Constructors

    public Sarray() {
	this( 100 );
    }

    public Sarray(int length){
	data = new int[length];
	rnd = new Random();
	for (int i = 0; i < length; i++){
	    data[i] = rnd.nextInt(100);
	}
	last = size() - 1;
    }

    public Sarray(int length, int[] list){
	data = new int[length];
        for (int i = 0; i < list.length; i++){
	    data[i] = list[i];
	}
	last = size() - 1;
    }

    // Methods
    
    public String toString(){
	String array = "";
	for (int i = 0; i < data.length; i++){
	    array+= data[i] + ", ";
	}
	return array;
    }

    // if you try to do something to an index that's not contained within
    // the list but may be within the array
    private void checkIndex(int index){
	if (index > last)
	    throw new IndexOutOfBoundsException();
    }


    private int[] grow(){
	int[] newData2;
	if (size() == data.length){
	    newData2 = new int[data.length + ( data.length / 2 ) ];
	}
	else
	    newData2 = new int[data.length];
	return newData2;
    }

    public int size(){
	int output = 0;
	for (int i = data.length - 1; i > 0; i--){
	    if (data[i] != 0){
	        output = i + 1;
		break;
	    }
	}
	return output;
    }

    public boolean add(int i){
	if (size() == data.length){
	    int[] newData = grow();
	    for (int n = 0; n <= last; n++){
		newData[n] = data[n];
	    }
	    newData[ last + 1 ] = i;
	    data = newData;
	}
	else {
	    data[ size() + 1 ] = i;
	}
	return true;
    }

    public void add( int index, int i ){
	checkIndex( index );
	int[] newData = grow();
	for (int x = 0; x < data.length; x++){
	    if (x < index)
		newData[x] = data[x];
	    else if (x == index)
		newData[x] = i;
	    else
		newData[x] = data[x-1];
	}
	data = newData;
    }

    public int get(int index){
	checkIndex( index );
	return data[index];
    }

    public int set(int index, int i){
	int old = data[index];
	data[index] = i;
	return old;
    }

    public int remove(int index){
	checkIndex( index );
	int old = data[index];
	int[] newData = new int[data.length];
	for (int i = 0; i < data.length; i++){
	    if (i < index){
		newData[i] = data[i];
	    }
	    else if (i > index){
		newData[i - 1] = data[i];
	    }
	}
	data = newData;
	return old;
    }

    // Main
    public static void main(String[] args){
	Sarray array = new Sarray();
	System.out.println( "Original" );
	System.out.println(array);
	System.out.println(array.size());
	System.out.println();
	System.out.println( "After add(5)" );
	array.add(5);
	System.out.println(array);
	System.out.println(array.size());
	System.out.println();
	System.out.println( "After add(5,5)" );
	array.add(5,5);
	System.out.println(array);
	System.out.println(array.size());
	System.out.println();
	System.out.println("What's at index 5?");
	System.out.println(array.get(5));	
	System.out.println();
	System.out.println("After setting the element at index 5 to 0");
	array.set(5, 0);
	System.out.println(array);
	System.out.println(array.size());
	System.out.println();
	System.out.println("After removing the element at index 5");
	array.remove(5);
	System.out.println(array);
	System.out.println(array.size());
	System.out.println();
	try {
	    System.out.println("Trying to remove the element at index 0");
	    array.remove(0);
	    System.out.println(array);
	    System.out.println("Trying to remove the element at index 9001");
	    array.remove(9001);
	} catch (IndexOutOfBoundsException e){
	    System.out.println(e);
	}
	System.out.println();
	try {
	    System.out.println("Trying to insert the element 9001 at index 5");
	    array.add(5, 9001);
	    System.out.println(array);
	    System.out.println(array.size());
	    System.out.println("Trying to insert the element 5 at index 9001");
	    array.add(9001, 5);
	    System.out.println(array);
	    System.out.println(array.size());
	} catch (IndexOutOfBoundsException e){
	    System.out.println(e);
	}
    }
}
