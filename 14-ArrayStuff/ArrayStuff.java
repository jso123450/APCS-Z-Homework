import java.util.*;

public class ArrayStuff {

    /*--------------------------Instance Variables---------------------------*/
    
    private int[] a;

    Random rnd;

    // By making x final, we can set it once, but then never change it
    // private final int x = 123;

    /*---------------------------Constructors--------------------------------*/

    public ArrayStuff(){
        this(100);
    }

    public ArrayStuff(int n){
	rnd = new Random();
	a = new int[n];
	for (int i = 0; i < a.length; i++){
	    a[i] = 75 + rnd.nextInt(76);
	}
    }

    /*--------------------------------Methods--------------------------------*/
    
    public String toString(){
	String s = "";
	// this is invalid because x is declared to be final (cannot be changed)
	// x = 321;
	for (int i = 0; i < a.length; i++){
	    s = s + a[i] + ", ";
	}
	return s;
    }

    public int find(int n){
	int output = -1;
	for (int i = 0; i < a.length; i++){
	    if (a[i] == n){
		output = i;
		break;
	    }
	}
	return output;
    }

    public int maxVal(){
	int output = a[0];
	for (int i = 1; i < a.length; i++){
	    if (a[i] > output){
		output = a[i];
	    }
	}
	return output;
    }

    public int freq(int i){
	if (i > a.length) {
	    return 0;
	}
	int element = a[i];
	int output = 0;
	for (int c = 0; c < a.length; c++){
	    if (a[c] == element){
		output++;
	    }
	}
	return output;
    }

    public int sum67(int[] nums) {
	int sum = 0;
	for (int i = 0; i < nums.length; i++){
	    if (nums[i] != 6){
		sum+= nums[i];
	    }
	    else {
		for (int c = i; c < nums.length; c++){
		    if (nums[c] == 7){
			i = c;
			break;
		    }
		}
	    }
	}
	return sum;
    }

    public boolean more14(int[] nums) {
	int ones = 0;
	int fours = 0;
	for (int i = 0; i < nums.length; i++){
	    if (nums[i] == 1){
		ones++;
	    }
	    else if (nums[i] == 4){
		fours++;
	    }
	}
	return ones > fours;
    }

    public int[] tenRun(int[] nums) {
	int[] output = new int[nums.length];
	int multiple = -1;
	for (int i = 0; i < nums.length; i++){
	    if ((nums[i] % 10) == 0){
		multiple = nums[i];
	    }
	    if (multiple == -1){
		output[i] = nums[i];
	    }
	    else {
		output[i] = multiple;
	    }
	}
	return output;
    }

    public boolean tripleUp(int[] nums) {
	if (nums.length < 3){
	    return false;
	}
	for (int i = 0; i + 3 <= nums.length; i++){
	    int counter = nums[i];
	    if ((nums[i+1] == (counter + 1)) && (nums[i+2] == (counter + 2))){
		return true;
	    }
	}
	return false;
    }

    public int[] seriesUp(int n) {
	int[] output = new int[ n*(n+1)/2 ];
	for (int i = 1; i <= n; i++){
	    int counter = 1;
	    while (counter <= i){
		output[i*(i-1)/2+counter-1] = counter;
		counter++;
	    }
	}
	return output;
    }
    /* Unfinished
    My approach:
      - if sum is odd return false
      - have an array with the consecutive sums from the left and another for the right
      - check for the same elements (thus the same sum of the elements) in the left and right arrays
      - check if the sum of the indexes of the element in the left array and the right array + 2 is equal to the length of the original
        (if this is true, then there is a way to balanace the array)
      - else return false


    public boolean canBalance(int[] nums) {
	int sum = 0;
	for (int i = 0; i < nums.length; i++){
	    sum+= nums[i];
	}
	if ((sum % 2) != 0){
	    return false;
	}
	int[] left = new int[nums.length];
	left[0] = nums[0];
	int[] right = new int[nums.length];
	right[0] = nums[nums.length-1];
	for (int i = 1; i < nums.length; i++){
	    left[i] = left[i-1] + nums[i];
	    right[i] = right[i-1] + nums[nums.length-i-1];
	}
	for (int i = 0; i < nums.length; i++){
	    int[] same = new int[nums.length];
	    for (int x = 0; x < nums.length; x++){
		int holder = left[x];
		for (int y = 0; y < nums.length; y++){
		    if (right[y] == holder){
			same[i] = holder;
		    }
		}
	    }
     
	}
	return false;
    }
    */

    /*-----------------------------Main Method-------------------------------*/
    
    public static void main(String[] args){
	ArrayStuff as = new ArrayStuff();
	System.out.println(as);
	System.out.println();
	System.out.println( as.find(100) );
	System.out.println();
	System.out.println( as.maxVal() );
	System.out.println();
	System.out.println( as.freq(5) );
    }

}
