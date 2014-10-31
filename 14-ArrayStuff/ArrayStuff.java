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

    // redone in class & finished with a cleaner approach

    public boolean canBalance(int[] nums) {
	for (int i = 0; i < nums.length; i++){
	    // create new array with elements coming from the left
	    int[] check = new int[i+1];
	    for (int c = 0; c <= i; c++){
		check[c] = nums[c];
	    }
	    // check the sum of the new array
	    int leftsum = 0;
	    for (int left = 0; left <= i; left++){
		leftsum+= check[left];
	    }
	    // check the sum of the elements not included in the new array
	    int rightsum = 0;
	    for (int right = i + 1; right < nums.length; right++){
		rightsum+= nums[right];
	    }
	    // if the two sums are equal, return true
	    if (leftsum == rightsum){
		return true;
	    }
	}
	// else return false
	return false;
    }


    // 45 mins
    public int maxMirror(int[] nums) {
	int len = nums.length;
	int c;
	int output = 0;
	for (int i = 0; i < len; i++){
	    c = 0;
	    for (int r = len - 1; ((i + c < len) && (r > -1)); r--){
		if (nums[i+c] == nums[r]) {
		    c++;
		}
		else{
		    if (c > 0){
			output = Math.max( output, c );
			c = 0;
		    }
		}
	    }
	    output = Math.max( output, c );
	}
	return output;
    }

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
