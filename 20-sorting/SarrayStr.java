import java.util.*;

public class SarrayStr{

    // Instance Variables
    private String[] data;
    private int last;

    // Constructors

    public SarrayStr() {
	this( 100 );
    }

    public SarrayStr(int length){
	data = new String[length];
	for (int i = 0; i < length; i++){
	    data[i] = "";
	}
	last = size() - 1;
    }
    
    public SarrayStr(int length, String[] list){
        data = new String[length];
	int i = 0;
        while (i < list.length){
	    data[i] = list[i];
	    i++;
	}
	last = list.length - 1;
	while (i < length){
	    data[i] = "";
	    i++;
	}
    }

    // Methods
    
    public String toString(){
	String array = "{";
	for (int i = 0; i < data.length; i++){
	    array+= data[i] + ", ";
	}
	array+= "}";
	return array;
    }

    // if you try to do something to an index that's not contained within
    // the list but may be within the array
    private void checkIndex(int index){
	if (index > last)
	    throw new IndexOutOfBoundsException();
    }


    private String[] grow(){
	String[] newData2;
	if (size() == data.length){
	    newData2 = new String[data.length + ( data.length / 2 ) ];
	    last++;
	    while (last <= (data.length / 2)){
		data[last] = ""; 
		last++;
	    }
	}
	else
	    newData2 = new String[data.length];
	return newData2;
    }

    public int size(){
	int output = 0;
	for (int i = data.length - 1; i > -1; i--){
	    if (!(data[i].equals(""))){
	        output = i + 1;
		break;
	    }
	}
	return output;
    }

    public boolean add(String s){
	if (size() == data.length){
	    String[] newData = grow();
	    for (int n = 0; n <= last; n++){
		newData[n] = data[n];
	    }
	    newData[ last + 1 ] = s;
	    data = newData;
	}
	else {
	    data[ size() ] = s;
	}
	last++;
	return true;
    }

    public void add( int index, String s ){
	checkIndex( index );
	String[] newData = grow();
	for (int x = 0; x < data.length; x++){
	    if (x < index)
		newData[x] = data[x];
	    else if (x == index)
		newData[x] = s;
	    else
		newData[x] = data[x-1];
	}
	data = newData;
	last++;
    }

    public String get(int index){
	checkIndex( index );
	return data[index];
    }

    public String set(int index, String s){
	String old = data[index];
	data[index] = s;
	return old;
    }

    public String remove(int index){
	checkIndex( index );
	String old = data[index];
        String[] newData = new String[data.length];
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
    
    public String[] getData(){
	return data;
    }
    
    public int getLast(){
	return last;
    }

    public void shift(int range, String s){
	int i;
	for (i = range; (i > 0) && (s.compareTo(data[i-1]) < 0); i--){
	    data[i] = data[i-1];
	}
	data[i] = s;
    }

    public void isort(){
	for (int n = 1; n <= last; n++){
	    shift(n, data[n]);
	}
    }

    public String findBiggest(int range){
	String biggest = data[0];
	for (int i = 1; i <= range; i++){
	    if (biggest.compareTo(data[i]) < 0)
		biggest = data[i];
	}
	return biggest;
    }

    public int findBiggestIndex(int range){
	int index = 0;
	for (int i = 1; i <= range; i++){
	    if (data[index].compareTo(data[i]) < 0)
		index = i;
	}
	return index;
    }
    
    public void ssort(){
	int j = last;
	while (j > -1){
	    String biggest = findBiggest(j);
	    int biggestIndex = findBiggestIndex(j);
	    data[biggestIndex] = data[j];
	    data[j] = biggest;
	    j--;
	}
    }

    public void bsort(){
	boolean keepRunning = true;
	while (keepRunning){
	    int swapsDone = 0;
	    for (int i = 0; i < last; i++){
		if (data[i].compareTo(data[i+1]) > 0){
		    String holder = data[i];
		    data[i] = data[i+1];
		    data[i+1] = holder;
		    swapsDone++;
		}
	    }
	    if (swapsDone == 0)
		keepRunning = false;
	}
    }
	
}
